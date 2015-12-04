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
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Restaurante;
import br.edu.univas.agencia.model.RestauranteReserva;
import br.edu.univas.agencia.restaurante.RestaurantService;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantBusinessTest {


	// Dependencies
	@Mock
	private RestaurantService restaurantService;

	@Mock
	private PackageBusiness packageBusiness;

	@Mock
	private Pacote pacote;

	@Mock
	private AgencyException agencyException;

	// Target
	@InjectMocks
	private RestaurantBussiness restaurantsBusiness;

	@Test
	public void listRestaurants() throws AgencyException {
		// given
		List<Restaurante> restaurants = new ArrayList<Restaurante>();
		BDDMockito.given(restaurantService.getAvailableRestaurantList(pacote))
				.willReturn(restaurants);

		// when
		List<Restaurante> result = (List<Restaurante>) restaurantsBusiness
				.listRestaurants(pacote);

		// then
		Assert.assertEquals(restaurants, result);
	}

	@Test
	public void createReservation() throws AgencyException{
		//give
		RestauranteReserva restaurantReserva = new RestauranteReserva();
		
		// when
		restaurantsBusiness.createReservation(restaurantReserva);
	}
}
