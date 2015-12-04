package br.edu.univas.agencia.agencia.service.api.impl;

import java.text.ParseException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import br.edu.univas.agencia.agencia.business.PackageBusiness;
import br.edu.univas.agencia.agencia.business.TuristicPointBusiness;
import br.edu.univas.agencia.agencia.service.api.TuristicPointService;
import br.edu.univas.agencia.agencia.service.api.domain.AtractionsReservation;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.PontoTuristico;

/**
 * Implementation of services defined in {@link TuristicPointService}.
 * 
 * @author edilson
 *
 */
@Path("/atractions")
public class TuristicPointServiceImpl implements TuristicPointService {

	PackageBusiness packageBusiness = new PackageBusiness();
	TuristicPointBusiness turistictPointBusiness = new TuristicPointBusiness();
	
	@GET
	@Override
	public List<PontoTuristico> listTuristicPoints(@QueryParam("packageId") int packageId) throws AgencyException, ParseException {
		return turistictPointBusiness.listTuristicPoints(packageId);
	}

	@POST
	@Path("/reservation")
	@Override
	public void createTuristicPointReservation(AtractionsReservation atractionsReservation) {
		turistictPointBusiness.createTuristicPointReservation(atractionsReservation);
	}

}
