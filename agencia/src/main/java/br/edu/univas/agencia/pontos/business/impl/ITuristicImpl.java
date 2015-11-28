package br.edu.univas.agencia.pontos.business.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import util.HibernateUtil;
<<<<<<< HEAD
import br.edu.univas.agencia.model.Cidade;
=======
>>>>>>> 0f3eced70caae5dace6ec62956cdccf3dfb303a3
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.PontoTuristico;
import br.edu.univas.agencia.pontos.pontosDAO.PontosTuristicosDAO;

public class ITuristicImpl {
	
	//Apenas de teste
	private PontosTuristicosDAO ptDAO;
	
	public ITuristicImpl(){
		ptDAO = new PontosTuristicosDAO(HibernateUtil.getEntityManager());
	}

	public List<PontoTuristico> getAvailableAttractions(Pacote pacote) throws ParseException{
		List<Date> daysBetweenPeriod = new ArrayList<Date>();
		
		//Get all attractions of the given city
		List<PontoTuristico> attractionsOfTheCity = null;
<<<<<<< HEAD

		//TODO: Retirar
		Cidade cidade = new Cidade();
		cidade.setId(6861);
		
		attractionsOfTheCity = ptDAO.getAttractionsByCity(cidade);
		//Apenas teste
=======
		attractionsOfTheCity = ptDAO.getAttractionsByCity(pacote.getCidade());
>>>>>>> 0f3eced70caae5dace6ec62956cdccf3dfb303a3
		
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
	
	public List<Date> getDaysOfPeriod(Pacote pacote, List<Date> daysBetweenPeriods) throws ParseException {
		Date dt1 = pacote.getDataInicio();
		Date dt2 = pacote.getDataFim();

		Calendar cal = Calendar.getInstance();
		cal.setTime(dt1);
		for (Date dt = dt1; dt.compareTo(dt2) <= 0;) {
			daysBetweenPeriods.add(dt);
			cal.add(Calendar.DATE, +1);
			dt = cal.getTime();
		}
		return daysBetweenPeriods;
	}

	
<<<<<<< HEAD
	//Checar se na tabela de reserva de cada ponto turÃ­stico, para cada dia, 
	//o nÃºmero total de reservas + o nÃºmero de pessoa do pacote Ã© menor 
	//ou igual ao nÃºmero de vagas daquele ponto turÃ­stico. Se for, entÃ£o
	//tal data Ã© colocada num map<data,boolean> dentro do objeto ponto 
	//turistico.
	public void getDaysAvailableForAttraction(PontoTuristico attraction, Date date, int numberOfPeople){
		
=======
	//Checar se na tabela de reserva de cada ponto turístico, para cada dia, 
	//o número total de reservas + o número de pessoa do pacote é menor 
	//ou igual ao número de vagas daquele ponto turístico. Se for, então
	//tal data é colocada num map<data,boolean> dentro do objeto ponto 
	//turistico.
	public void getDaysAvailableForAttraction(PontoTuristico attraction, Date date, int numberOfPeople){
	
>>>>>>> 0f3eced70caae5dace6ec62956cdccf3dfb303a3
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
