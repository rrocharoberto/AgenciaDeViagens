package br.edu.univas.agencia.agencia.business;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.hotel.HotelService;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;

@RunWith(MockitoJUnitRunner.class)
public class HotelBusinessTest {
	
	@Mock
	private HotelService hotelService;
	
	@Mock
	private PackageBusiness packageBusiness;
	
	@Mock
	private Pacote pacote;
	
	@Mock
	private AgencyException agencyException;
	
	@InjectMocks
	private HotelBusiness hotelBusiness;
	
	@Test
	public void listHotels() throws AgencyException{
		//given
		List<Hotel> hotels = new ArrayList<Hotel>();
		BDDMockito.given(hotelService.getAvailableHotelList(pacote)).willReturn(hotels);
		
		//when
		List<Hotel> result = (List<Hotel>) hotelBusiness.listHotels(pacote);
		
		//then
		Assert.assertEquals(hotels, result);
	}
	
	@Test
	public void createReservation() throws AgencyException{
		
		//given
		HotelReserva hotelReserva = new HotelReserva();
		
		//when
		hotelBusiness.createReservation(hotelReserva);
	}
	
}
