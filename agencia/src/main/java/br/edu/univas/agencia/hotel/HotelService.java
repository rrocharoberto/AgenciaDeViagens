package br.edu.univas.agencia.hotel;

import java.util.List;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;

public class HotelService implements  IHotel{

	@Override
	public Hotel createHotel(Hotel hotel) throws AgencyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel updateHotel(Hotel hotel) throws AgencyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hotel deleteHotel(Integer hotelID) throws AgencyException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Hotel> getAllHotel() throws AgencyException {
		// TODO Auto-generated method stub
		return null;
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
