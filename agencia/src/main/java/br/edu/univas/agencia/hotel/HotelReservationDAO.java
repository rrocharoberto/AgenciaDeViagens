package br.edu.univas.agencia.hotel;

import javax.persistence.EntityManager;

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
	 * Default constructor.
	 * 
	 * @param {@link EntityManager} entityManager
	 */
	public HotelReservationDAO(EntityManager entityManager){
		super (entityManager);
	}

}