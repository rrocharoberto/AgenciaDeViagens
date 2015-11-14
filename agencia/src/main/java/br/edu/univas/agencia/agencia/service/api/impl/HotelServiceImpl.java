package br.edu.univas.agencia.agencia.service.api.impl;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

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
@Path("/hotel")
public class HotelServiceImpl implements HotelService {

	@GET
	@Override
	public Collection<Hotel> listHotels(Pacote pacote) throws AgencyException {
		// TODO return hotelBusiness.listHotels();
		return null;
	}

	@POST
	@Path("/reservation")
	@Override
	public void createHotelReservation(Pacote pacote, HotelReserva hotelReserva)
			throws AgencyException {
		// TODO packageValidator.validatePackage();
		// TODO hotelBusiness.validateReservation();
		// TODO hotelBusiness.createFlightReservation();		
	}

}