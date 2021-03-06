package br.edu.univas.agencia.hotel;

import java.util.List;

import util.HibernateUtil;
import br.edu.univas.agencia.agencia.dao.CityDAO;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;

/**
 * This class is responsible by business logic of hotel.
 * 
 * @implements interface {@link IHotelService}
 */
public class HotelService implements  IHotelService{
	
	private HotelDAO dao;
	private CityDAO cityDAO;
	private HotelReservationDAO reservationDAO;
		
	/**
	 * Method responsible for the hotel registration
	 * 
	 * @param hotel
	 * @return 
	 * 
     * @throws AgencyException 
	 */
	@Override
	public Hotel createHotel(Hotel hotel) throws AgencyException {
		try {
			dao = new HotelDAO(HibernateUtil.getEntityManager());
			dao.salvar(hotel);	
		} catch (Exception ex) {
			throw new AgencyException("Problemas ao salvar Hotel: " + ex.getMessage());
		}
		return null;
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
	 * Method responsible to get City by Id
	 * 
	 * @param {@link Integer} cityId
	 * 
	 * @return {@link Cidade}
	 * 
	 * @throws AgencyException
	 */
	public Cidade getCityById(Integer cityId) throws AgencyException{
		try {
			cityDAO = new CityDAO();
			return cityDAO.getById(cityId, HibernateUtil.getEntityManager());
		} catch (Exception ex) {
			throw new AgencyException("Problemas ao buscar a cidade do Hotel: " + ex.getMessage());
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
		try {
			reservationDAO = new HotelReservationDAO(HibernateUtil.getEntityManager());
			reservationDAO.salvar(reserve);
		} catch (Exception ex) {
			throw new AgencyException("Problemas ao salvar reserva: " + ex.getMessage());
		}
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
		try {
			dao = new HotelDAO(HibernateUtil.getEntityManager());
			List<Hotel> availableHotelList = dao.getAvailableHotelList(bundle);
			return availableHotelList;
		} catch (Exception ex) {
			throw new AgencyException("Problemas ao buscar os Hotéis com vaga: " + ex.getMessage());
		}
	}
}
