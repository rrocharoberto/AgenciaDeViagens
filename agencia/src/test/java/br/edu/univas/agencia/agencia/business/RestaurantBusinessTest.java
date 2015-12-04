package br.edu.univas.agencia.agencia.business;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.PontoTuristico;
import br.edu.univas.agencia.model.Restaurante;
import br.edu.univas.agencia.model.RestauranteReserva;
import br.edu.univas.agencia.restaurante.IRestaurant;
import br.edu.univas.agencia.restaurante.RestaurantService;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantBusinessTest {

	private static final int PACKAGE_ID = 1;

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
