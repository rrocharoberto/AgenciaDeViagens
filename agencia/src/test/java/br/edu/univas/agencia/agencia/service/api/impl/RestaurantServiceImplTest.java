package br.edu.univas.agencia.agencia.service.api.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.univas.agencia.agencia.business.PackageBusiness;
import br.edu.univas.agencia.agencia.business.RestaurantBussiness;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Restaurante;
import br.edu.univas.agencia.model.RestauranteReserva;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantServiceImplTest {

	private static final int PACKAGE_ID = 1;
	
	// Dependencies
	@Mock
	private RestaurantBussiness restaurantBusiness;
	
	@Mock
	private PackageBusiness packageBusiness;

	@Mock
	private AgencyException agencyException;

	// Target
	@InjectMocks
	private RestaurantServiceImpl restaurantServiceImpl;


	@Test
	public void listResturants() throws AgencyException {
		
		// given
		Pacote pacote = new Pacote();
		Collection<Restaurante> restaurants = new ArrayList<Restaurante>();
		BDDMockito.given(packageBusiness.retrievePackage(PACKAGE_ID)).willReturn(pacote);
		BDDMockito.given(restaurantBusiness.listRestaurants(pacote)).willReturn(restaurants);
		
		
		// when
		Collection<Restaurante> result = restaurantServiceImpl.listRestaurants(PACKAGE_ID);

		// then
		assertEquals(restaurants, result);
	}
	
	@Test
	public void createRestaurantReservation() throws AgencyException {
		
		// given
		RestauranteReserva restauranteReserva = new RestauranteReserva();
		
		
		// when
		restaurantServiceImpl.createRestaurantReservation(restauranteReserva);

	}
	
}
