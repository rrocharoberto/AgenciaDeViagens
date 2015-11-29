package br.edu.univas.agencia.hotel;

import java.util.List;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;

public interface IHotelService extends  IHotel {
	
	@Override
	public void createHotel(Hotel hotel) throws AgencyException;
	
	@Override
	public void updateHotel(Hotel hotel) throws AgencyException;
	
	@Override
	public void deleteHotel(Integer hotelID) throws AgencyException;
	
	@Override
	public List<Hotel> getAllHotel() throws AgencyException;
	
	@Override
	public void reservRoom(HotelReserva reserve) throws AgencyException;
	
	@Override
	public List<Hotel> getAvailableHotelList(Pacote bundle) throws AgencyException;
}
