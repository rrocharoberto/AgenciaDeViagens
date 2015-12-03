package br.edu.univas.agencia.hotel;

import java.util.List;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;

/**
 * Interface that provide the signature to the CRUD methods of hotel module
 * 
 * @extends interface {@link IHotel}
 */
public interface IHotelService extends IHotel {
	
	/**
	 * Method responsible to the Create Operation
	 * 
	 * @param {@link Hotel} hotel
	 * @return 
	 * 
	 * @throws AgencyException
	 */
	public Hotel createHotel(Hotel hotel) throws AgencyException;
	
	/**
	 * Method responsible to the Update Operation
	 * 
	 * @param {@link Hotel} hotel
	 * 
	 * @throws AgencyException
	 */
	public void updateHotel(Hotel hotel) throws AgencyException;
	
	/**
	 * Method responsible to the Delete Operation
	 * 
	 * @param {@link Integer} hotelID
	 * 
	 * @throws AgencyException
	 */
	public void deleteHotel(Integer hotelID) throws AgencyException;
	
	/**
	 * Method responsible to the Retrieve Operation
	 * 
	 * @return {@link List<Hotel>} hotelList
	 * 
	 * @throws AgencyException
	 */	
	public List<Hotel> getAllHotel() throws AgencyException;
	
	/**
	 * Method responsible to the rooms reservation.
	 * This method is coming from {@link IHotel} Interface. 
	 */
	@Override
	public void reservRoom(HotelReserva reserve) throws AgencyException;
	
	/**
	 * Method responsible retrieve ll hotels are available.
	 * This method is coming from {@link IHotel} Interface. 
	 */
	@Override
	public List<Hotel> getAvailableHotelList(Pacote bundle) throws AgencyException;
}
