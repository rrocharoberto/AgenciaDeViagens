package br.edu.univas.agencia.agencia.service.api.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import br.edu.univas.agencia.agencia.service.api.FlightService;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Voo;
import br.edu.univas.agencia.model.VooReserva;

/**
 * Implementation of services defined in {@link FlightService}.
 * @author edilson
 *
 */
@Path("/flight")
public class FlightServiceImpl implements FlightService {

	@GET
	@Path("/type")
	@Override
	public List<Integer> listFlightTypes(Pacote pacote) throws AgencyException {
		// TODO packageValidator.validatePackage();
		// TODO return flightBusiness.listFlightTypes();
		return null;
	}

	@GET
	@Override
	public Map<String, Collection<Voo>> listFlights(Pacote pacote)
			throws AgencyException {
		// TODO packageValidator.validatePackage();
		// TODO return flightBusiness.listFlights();
		return null;
	}

	@POST
	@Path("/reservation")
	@Override
	public void createFlightReservation(Pacote pacote, VooReserva vooReserva)
			throws AgencyException {
		// TODO packageValidator.validatePackage();
		// TODO flightBusiness.validateReservation();
		// TODO flightBusiness.createFlightReservation();
		
	}

}
