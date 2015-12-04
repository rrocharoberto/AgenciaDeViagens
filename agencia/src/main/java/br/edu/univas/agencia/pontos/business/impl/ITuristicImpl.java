package br.edu.univas.agencia.pontos.business.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import util.HibernateUtil;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.PontoTuristico;
import br.edu.univas.agencia.model.ReservaPontosTuristicos;
import br.edu.univas.agencia.pontos.pontosDAO.PontosTuristicosDAO;

public class ITuristicImpl {
	
	private PontosTuristicosDAO ptDAO;
	
	public ITuristicImpl(){
		ptDAO = new PontosTuristicosDAO(HibernateUtil.getEntityManager());
	}
	
	public void doReservation(List<PontoTuristico> pontosTuristicos, Pacote pacote){
		List<ReservaPontosTuristicos> rpt = new ArrayList<ReservaPontosTuristicos>();
		
		for(PontoTuristico pt : pontosTuristicos){
			for(Date key : pt.getDaysAvailable().keySet()){
				if(pt.getDaysAvailable().get(key)){
					rpt.add(new ReservaPontosTuristicos(pacote,pt,key));
				}
			}
		}
	}

	public List<PontoTuristico> getAvailableAttractions(Pacote pacote) throws ParseException{
		List<Date> daysBetweenPeriod = new ArrayList<Date>();
		
		//Get all attractions of the given city
		List<PontoTuristico> attractionsOfTheCity = null;
		
		attractionsOfTheCity = ptDAO.getAttractionsByCity(pacote.getCidade());
		
		//Get all days of the given period.
		getDaysOfPeriod(pacote,daysBetweenPeriod);
		
		//Get days available for each attractions.
		for(PontoTuristico attraction : attractionsOfTheCity){
			for(Date date : daysBetweenPeriod){
				getDaysAvailableForAttraction(attraction, date, pacote.getQuantidadePessoas());
			}
		}
		
		//Remove attractions which is not available in the 
		//period defined in the package.
		removeAttractionsNotAvailable(attractionsOfTheCity);
		
		return attractionsOfTheCity;
	}
	
	public void getDaysOfPeriod(Pacote pacote, List<Date> daysBetweenPeriods) throws ParseException {
		Date dt1 = pacote.getDataInicio();
		Date dt2 = pacote.getDataFim();

		Calendar cal = Calendar.getInstance();
		cal.setTime(dt1);
		for (Date dt = cal.getTime(); dt.compareTo(dt2) <= 0;) {
			daysBetweenPeriods.add(dt);
			cal.add(Calendar.DATE, +1);
			dt = cal.getTime();
		}
	}
	
	//Checar se na tabela de reserva de cada ponto turístico, para cada dia, 
	//o número total de reservas + o número de pessoa do pacote é menor 
	//ou igual ao número de vagas daquele ponto turístico. Se for, então
	//tal data é colocada num map<data,boolean> dentro do objeto ponto 
	//turistico.
	public void getDaysAvailableForAttraction(PontoTuristico attraction, 
			Date date, int numberOfPeople){
		
		List<ReservaPontosTuristicos> reservasPontosTuristicos = null;
		reservasPontosTuristicos = ptDAO.getReservationAttractions(attraction, date);
		int totalReserved = 0;
		int reservasAvailable = 0;
		
		for(ReservaPontosTuristicos rpt : reservasPontosTuristicos){
			totalReserved = rpt.getPacote().getQuantidadePessoas();
		}
		
		reservasAvailable = attraction.getNumeroVagas() - totalReserved;
		
		if(reservasAvailable >= numberOfPeople){
			attraction.getDaysAvailable().put(date, false);
		}
			
	}
	
	public void removeAttractionsNotAvailable(List<PontoTuristico> attractions){
		
		//This is because the concurrency alteration problem
		List<PontoTuristico> attractionsToBeRemoved = new ArrayList<PontoTuristico>();
		
		for(PontoTuristico pt : attractions){
			if(pt.getDaysAvailable().isEmpty()){
				attractionsToBeRemoved.add(pt);
			}
		}
		attractions.removeAll(attractionsToBeRemoved);
	}
}
