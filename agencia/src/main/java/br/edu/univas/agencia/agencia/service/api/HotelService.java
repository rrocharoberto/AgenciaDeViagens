package br.edu.univas.agencia.agencia.service.api;

import java.util.Collection;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;

/**
 * Interface to define the services related to hotel.
 * 
 * @author edilson
 *
 */
public interface HotelService {

	/**
	 * get the hotels available.
	 * 
	 * @param pacote
	 * @return the list of hotels available.
	 * @throws AgencyException
	 */
	Collection<Hotel> listHotels(Pacote pacote) throws AgencyException;

	/**
	 * create reservation for hotel.
	 * 
	 * @param pacote
	 * @param hotelReserva
	 * @throws AgencyException
	 */
	void createHotelReservation(Pacote pacote, HotelReserva hotelReserva)
			throws AgencyException;

}
