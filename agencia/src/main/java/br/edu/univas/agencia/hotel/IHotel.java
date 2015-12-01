package br.edu.univas.agencia.hotel;

import java.util.List;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;

/**
 * 
 * Interface that define the hotel's methods of communication with agency system. 
 * These methods provide the hotel reservation registration and search for available hotels.
 *
 */
public interface IHotel {
	
	/**
	 * Method responsible to provide the rooms reservation of hotel module
	 * 
	 * @param {@link HotelReserva} reserve
	 * 
	 * @throws AgencyException
	 */
	public void reservRoom(HotelReserva reserve) throws AgencyException;

	/**
	 * Method responsible to provide all hotels are available
	 * 
	 * @param {@link Pacote} bundle
	 * 
	 * @return {@link List<Hotel>}
	 * 
	 * @throws AgencyException hotelList
	 */
	public List<Hotel> getAvailableHotelList(Pacote bundle) throws AgencyException;

	//public Report generateReport(HotelReportQuery reportQuery) throws AgencyException;
	
}
