package br.edu.univas.agencia.agencia.business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.edu.univas.agencia.agencia.service.api.domain.Atraction;
import br.edu.univas.agencia.agencia.service.api.domain.AtractionsReservation;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.PontoTuristico;
import br.edu.univas.agencia.pontos.business.impl.ITuristicImpl;

public class TuristicPointBusiness {

	private final ITuristicImpl ituristicImpl;
	private final PackageBusiness packageBusiness;

	public TuristicPointBusiness() {
		this.ituristicImpl = new ITuristicImpl();
		this.packageBusiness = new PackageBusiness();
	}

	public List<PontoTuristico> listTuristicPoints(int packageId) throws AgencyException, ParseException {
		Pacote pacote = packageBusiness.retrievePackage(packageId);
		return ituristicImpl.getAvailableAttractions(pacote);
	}

	public void createTuristicPointReservation(AtractionsReservation atractionsReservation) {
		List<PontoTuristico> pontosTuristicos = new ArrayList<PontoTuristico>();
		for(Atraction atraction: atractionsReservation.getAtractions()) {
			PontoTuristico ponto = new PontoTuristico();
			ponto.setCidade(atraction.getCidade());
			ponto.setDescricao(atraction.getDescricao());
			ponto.setId(atraction.getId());
			ponto.setNumeroVagas(atraction.getNumeroVagas());
			ponto.setReservaPontosTuristicoses(atraction.getReservaPontosTuristicoses());
			Map<Date, Boolean> daysAvailable = new HashMap<Date, Boolean>();
			
			for (Map.Entry<String, Boolean> entry : atraction.getDaysAvailable().entrySet()) {
//			    System.out.println(entry.getKey() + "/" + entry.getValue());
				daysAvailable.put(new Date(entry.getKey()), entry.getValue());
			}
			ponto.setDaysAvailable(daysAvailable);
			pontosTuristicos.add(ponto);
		}
		
		ituristicImpl.doReservation(pontosTuristicos, atractionsReservation.getPacote());
	}
}
