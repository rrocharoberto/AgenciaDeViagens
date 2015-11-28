package br.edu.univas.agencia.agencia.business;

import java.text.ParseException;
import java.util.List;

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
		Pacote pacote = packageBusiness.retrivePackage(packageId);
		return ituristicImpl.getAvailableAttractions(pacote);
	}

	public void createTuristicPointReservation(
			AtractionsReservation atractionsReservation) {
		// TODO: Convert to list of Turistic points
	}
}
