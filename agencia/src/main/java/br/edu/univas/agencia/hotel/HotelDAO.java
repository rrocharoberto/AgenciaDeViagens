package br.edu.univas.agencia.hotel;

import java.util.List;

import javax.persistence.EntityManager;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;

/**
 * 
 * Class responsible by perform operations of hotel module in database
 * 
 * @extends GenericHotelDAO
 *
 */
public class HotelDAO extends GenericHotelDAO<Hotel, Integer> {

	/**
	 * Superclass default constructor.
	 * 
	 * @param {@link EntityManager} em
	 */
	public HotelDAO(EntityManager em) {
		super(em);
	}
//	@Override
//	public void salvar(Hotel hotel){
//		em.getTransaction().begin();
//
//		em.persist(hotel);
//
//		em.getTransaction().commit();
//	}
	
	/**
	 * Method responsible for reservations operation in the database
	 * 
	 * @param {@link HotelReserve} reserve
	 * 
	 */	
	public void reservRoom(HotelReserva reserve){
		//TODO: reservRoom logic
	}

	/**
	 * method responsible for the search of hotels are available in the database
	 * 
	 * @param {@link Pacote} bundle
	 * 
	 * @return {@link List<Hotel>} availableHotelList
	 */
	public List<Hotel> getAvailableHotelList(Pacote bundle) {
		//TODO: getAvailableHotelList logic
		return null;
	}
	
	/**
	 * Method responsible for generation of hotel module report 
	 * @param {@link Hotel} hotel
	 * @return TODO: RETURN COMMENT
	 */
	public List<Hotel> generateHotelReport(Hotel hotel) {
		//TODO: generateHotelReport logic
		return null;
	}
}