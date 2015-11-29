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

public class HotelService implements  IHotelService{
	
	private HotelDAO dao;
	
	@Override
	public void createHotel(Hotel hotel) throws AgencyException {
		try {
			dao = new HotelDAO(HibernateUtil.getEntityManager());
			dao.salvar(hotel);	
		} catch (Exception ex) {
			throw new AgencyException("Problemas ao salvar Hotel: " + ex.getMessage());
		}
	}

	@Override
	public void updateHotel(Hotel hotel) throws AgencyException {
		try {
			dao = new HotelDAO(HibernateUtil.getEntityManager());
			dao.update(hotel);	
		} catch (Exception ex) {
			throw new AgencyException("Problemas ao editar Hotel: " + ex.getMessage());
		}
	}

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

	@Override
	public List<Hotel> getAllHotel() throws AgencyException {
		try {
			dao = new HotelDAO(HibernateUtil.getEntityManager());
			return dao.getAll();
		} catch (Exception ex) {
			throw new AgencyException("Problemas ao buscar os Hotéis: " + ex.getMessage());
		}
	}
	
	@Override
	public void reservRoom(HotelReserva reserve) throws AgencyException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Hotel> getAvailableHotelList(Pacote bundle)
			throws AgencyException {
		// TODO Auto-generated method stub
		return null;
	}
}
