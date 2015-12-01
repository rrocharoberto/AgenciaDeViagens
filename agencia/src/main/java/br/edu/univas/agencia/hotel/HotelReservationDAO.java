package br.edu.univas.agencia.hotel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.HotelReserva;

/**
 * 
 * Class responsible by perform operations of hotel_reserva service in database
 * 
 * @extends GenericHotelDAO
 *
 */
public class HotelReservationDAO extends GenericHotelDAO<HotelReserva, Integer> {
	
	/**
	 * Superclass default constructor.
	 * 
	 * @param {@link EntityManager} entityManager
	 */
	public HotelReservationDAO(EntityManager entityManager){
		super (entityManager);
	}
	
	/**
	 * Method responsible for create hotelReserva operation in the database
	 * 
	 * @param {@link HotelReserva} hotelReserva
	 * 
	 * @throws AgencyException
	 */
	public void save_HotelReservation(HotelReserva hotelReserva)throws AgencyException{
		super.salvar(hotelReserva);
	}
	
	/**
	 * Method responsible for list all hotelReserva registered in the database
	 * 
	 * @param {@link HotelReserva} hotelReserva
	 * 
	 * @return {@link List<HotelReserva>} hotelReservaList
	 * 
	 * @throws AgencyException
	 */
	public List<HotelReserva> listHotelReservation(HotelReserva hotelReserva)throws AgencyException{
		List<HotelReserva>hotelReservaList=new ArrayList<HotelReserva>();
		hotelReservaList=super.getAll();
		return hotelReservaList;
	}
}