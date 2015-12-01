package br.edu.univas.agencia.agencia.service.api.impl;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import br.edu.univas.agencia.agencia.business.HotelBusiness;
import br.edu.univas.agencia.agencia.business.PackageBusiness;
import br.edu.univas.agencia.agencia.service.api.HotelService;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;


/**
 * Implementation of services defined in {@link HotelService}.
 * @author edilson
 *
 */
@Path("/hotelAgency")
public class HotelServiceImpl implements HotelService {

	PackageBusiness packageBusiness = new PackageBusiness();
	HotelBusiness hotelBusiness = new HotelBusiness();
	
	@GET
	@Override
	public Collection<Hotel> listHotels(@QueryParam("packageId") int packageId) throws AgencyException {
		Pacote pacote = packageBusiness.retrievePackage(packageId);
		return hotelBusiness.listHotels(pacote);
	}

	@POST
	@Path("/reservation")
	@Override
	public void createHotelReservation(HotelReserva hotelReserva)
			throws AgencyException {
		hotelBusiness.createReservation(hotelReserva);		
	}

}
