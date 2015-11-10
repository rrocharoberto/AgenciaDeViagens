package br.edu.univas.agencia.service.api.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.univas.agencia.hotel.service.IHotel;
import br.edu.univas.agencia.model.AgencyException;
import br.edu.univas.agencia.model.Hotel;

@RunWith(MockitoJUnitRunner.class)
public class HotelServiceImplTest {

	// Dependencies
	@Mock
	private IHotel iHotel;

	@Mock
	private AgencyException agencyException;

	// Target
	@InjectMocks
	private HotelServiceImpl hotelServiceImpl;

	@Test
	public void shouldFindAll() throws AgencyException {
		// given
		List<Hotel> expectedHotels = buildHotels();
		given(iHotel.findAll()).willReturn(expectedHotels);

		// when
		List<Hotel> result = hotelServiceImpl.findAll();

		// then
		assertEquals(expectedHotels.size(), result.size());
		assertEquals(expectedHotels, result);
	}

	@Test(expected = AgencyException.class)
	public void shouldThrowAgencyException() throws AgencyException {
		// given
		willThrow(agencyException).given(iHotel).findAll();

		// when
		hotelServiceImpl.findAll();

		// then
		// throw exception
	}

	private List<Hotel> buildHotels() {
		List<Hotel> hotels = new ArrayList<Hotel>();
		hotels.add(new Hotel(1, "teste"));
		hotels.add(new Hotel(2, "teste 2"));

		return hotels;
	}
}
