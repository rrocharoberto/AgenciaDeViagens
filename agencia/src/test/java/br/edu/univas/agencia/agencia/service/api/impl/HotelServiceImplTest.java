package br.edu.univas.agencia.agencia.service.api.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.univas.agencia.agencia.business.HotelBusiness;
import br.edu.univas.agencia.agencia.business.PackageBusiness;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;

@RunWith(MockitoJUnitRunner.class)
public class HotelServiceImplTest {
	
	private static final int PACKAGE_ID = 1;
	
	@Mock
	private PackageBusiness packageBusiness;
	@Mock
	private HotelBusiness hotelBusiness;
	
	@Mock
	private HotelReserva hotelReserva;
	
	@InjectMocks
	private HotelServiceImpl hotelServiceImpl;
	
	@Test
	public void shouldListHotels() throws AgencyException{
		
		Pacote pacote = new Pacote();
		Collection<Hotel> hotels = new ArrayList<Hotel>();
		BDDMockito.given(packageBusiness.retrievePackage(PACKAGE_ID)).willReturn(pacote);
		BDDMockito.given(hotelBusiness.listHotels(pacote)).willReturn(hotels);
		
		//when
		
		Collection<Hotel> result = hotelServiceImpl.listHotels(PACKAGE_ID);
		
		//then
		Assert.assertEquals(hotels, result);
	}
	
	@Test
	public void shouldCreateHotelReservation() throws AgencyException{
		
		//given
		HotelReserva hotelReserva = new HotelReserva();
		
		//when
		hotelServiceImpl.createHotelReservation(hotelReserva);
		
		//then
		// no Exception 
	}
}
