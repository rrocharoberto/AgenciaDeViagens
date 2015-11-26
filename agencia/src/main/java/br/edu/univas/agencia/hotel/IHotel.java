package br.edu.univas.agencia.hotel;

import java.util.List;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;

public interface IHotel {

	public Hotel createHotel(Hotel hotel) throws AgencyException;
	
	public Hotel updateHotel(Hotel hotel) throws AgencyException;
	
	public Hotel deleteHotel(Integer hotelID) throws AgencyException;
	
    public List<Hotel> getAllHotel() throws AgencyException;
	
	public void reservRoom(HotelReserva reserve) throws AgencyException;

	public List<Hotel> getAvailableHotelList(Pacote bundle) throws AgencyException;

	//public Report generateReport(HotelReportQuery reportQuery) throws AgencyException;
	
}
