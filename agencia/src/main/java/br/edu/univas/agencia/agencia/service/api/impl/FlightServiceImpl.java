package br.edu.univas.agencia.agencia.service.api.impl;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import br.edu.univas.agencia.agencia.business.FlightBusiness;
import br.edu.univas.agencia.agencia.business.PackageBusiness;
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

	private PackageBusiness packageBusiness = new PackageBusiness();
	private FlightBusiness flightBusiness = new FlightBusiness();
	
	@GET
	@Path("/type")
	@Override
	public List<Integer> listFlightTypes(@QueryParam("packageId") int packageId) throws AgencyException {
		Pacote pacote = packageBusiness.retrievePackage(packageId);
		return flightBusiness.listFlightTypes(pacote);
	}

	@GET
	@Override
	public Collection<Voo> listFlights(@QueryParam("packageId") int packageId) throws AgencyException {
		Pacote pacote = packageBusiness.retrievePackage(packageId);
		return flightBusiness.listFlights(pacote);
	}

	@POST
	@Path("/reservation")
	@Override
	public void createFlightReservation(VooReserva vooReserva)
			throws AgencyException {
		flightBusiness.createFlightReservation(vooReserva);
		
	}

}
