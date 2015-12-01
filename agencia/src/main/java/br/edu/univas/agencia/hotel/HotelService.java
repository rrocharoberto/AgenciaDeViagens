package br.edu.univas.agencia.hotel;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import util.HibernateUtil;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.restaurante.IRestaurant;

/**
 * This class is responsible by business logic of hotel.
 * 
 * @implements interface {@link IHotelService}
 */
public class HotelService implements  IHotelService{
	
	private HotelDAO dao;
		
	/**
	 * Method responsible for the hotel registration
	 * 
	 * @param hotel
	 * 
     * @throws AgencyException 
	 */
	@Override
	public void createHotel(Hotel hotel) throws AgencyException {
		try {
			dao = new HotelDAO(HibernateUtil.getEntityManager());
			dao.salvar(hotel);	
		} catch (Exception ex) {
			throw new AgencyException("Problemas ao salvar Hotel: " + ex.getMessage());
		}
	}

	/**
	 * Method responsible for updating of the registered hotel
	 * 
	 * @param hotel
	 * 
     * @throws AgencyException 
	 */
	@Override
	public void updateHotel(Hotel hotel) throws AgencyException {
		try {
			dao = new HotelDAO(HibernateUtil.getEntityManager());
			dao.update(hotel);	
		} catch (Exception ex) {
			throw new AgencyException("Problemas ao editar Hotel: " + ex.getMessage());
		}
	}

	/**
	 * Method responsible to delete one registered hotel
	 * 
	 * @param {@link Integer} hotelID
	 * 
     * @throws AgencyException 
	 */
	@Override
	public void deleteHotel(Integer hotelID) throws AgencyException {
		try{
		
			dao = new HotelDAO(HibernateUtil.getEntityManager());
			Hotel hotel = dao.getById(hotelID);
			hotel.setActive(false);
			dao.update(hotel);
			
		} catch (Exception ex) {
			throw new AgencyException("Problemas ao deletar Hotel: " + ex.getMessage());
		}
	}

	/**
	 * Method responsible to get all registered hotels
	 * 
	 * @return {@link List<Hotel>}
	 * 
     * @throws AgencyException  
	 */
	@Override
	public List<Hotel> getAllHotel() throws AgencyException {
		try {
			dao = new HotelDAO(HibernateUtil.getEntityManager());
			return dao.getAll();
		} catch (Exception ex) {
			throw new AgencyException("Problemas ao buscar os Hotéis: " + ex.getMessage());
		}
	}
	
	/**
	 * Method responsible to reserve a room of hotel 
	 * 
	 * @param {@link HotelReserva} reserve
	 * 
	 * @throws AgencyException 
	 */
	@Override
	public void reservRoom(HotelReserva reserve) throws AgencyException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Method responsible to get all hotels are available
	 * 
	 * @param {@link Pacote} bundle
	 * 
	 * @return {@link List<Hotel>} availableHotelList
	 * 
	 * @throws AgencyException 
	 */
	@Override
	public List<Hotel> getAvailableHotelList(Pacote bundle) throws AgencyException {
		// TODO Auto-generated method stub
		return null;
	}
}
