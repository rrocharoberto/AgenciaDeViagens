package br.edu.univas.agencia.agencia.business;

import java.util.Collection;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.hotel.HotelService;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.Pacote;

public class HotelBusiness {
	
	private HotelService hotelService;
	
	public HotelBusiness() {
		this.hotelService = new HotelService();
	}
	
	public Collection<Hotel> listHotels(Pacote pacote) throws AgencyException{
		
		return hotelService.getAvailableHotelList(pacote);
	}

}
