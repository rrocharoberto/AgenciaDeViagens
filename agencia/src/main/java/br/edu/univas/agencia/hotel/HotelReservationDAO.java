package br.edu.univas.agencia.hotel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.HotelReserva;

public class HotelReservationDAO extends GenericHotelDAO<HotelReserva, Integer> {
//	private EntityManager entityManager;
	
	public HotelReservationDAO(EntityManager entityManager){
		super (entityManager);
	}
	
	public void save_HotelReservation(HotelReserva hotelReserva)throws AgencyException{
//		String sql="insert into hotel_reserva(pacote,hotel,datareserva) values(?,?,?)";
		super.salvar(hotelReserva);;
	}
	
	public List<HotelReserva> hotelCheckReservation(HotelReserva hotelReserva)throws AgencyException{
//		String sql="insert into hotel_reserva(pacote,hotel,datareserva) values(?,?,?)";
		List<HotelReserva>hotelReservaList=new ArrayList<HotelReserva>();
		hotelReservaList=super.getAll();;
		return hotelReservaList;
	}
}