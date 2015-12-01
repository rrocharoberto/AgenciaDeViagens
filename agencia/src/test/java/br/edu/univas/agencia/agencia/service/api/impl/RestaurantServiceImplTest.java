package br.edu.univas.agencia.agencia.service.api.impl;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Assert;
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
	public void shouldListRestaraunts() throws AgencyException {
		
		// given
		Pacote pacote = new Pacote();
		Collection<Restaurante> restaurantes = new ArrayList<Restaurante>();
		BDDMockito.given(packageBusiness.retrievePackage(PACKAGE_ID)).willReturn(pacote);
		BDDMockito.given(restaurantBusiness.listRestaurants(pacote)).willReturn(restaurantes);
		
		// when
		ArrayList<Restaurante> result = (ArrayList<Restaurante>) restaurantServiceImpl.listRestaurants(PACKAGE_ID);
		
		// then
		Assert.assertEquals(restaurantes, result);
		BDDMockito.verify(packageBusiness).retrievePackage(PACKAGE_ID);
		BDDMockito.verify(restaurantBusiness).listRestaurants(pacote);
		BDDMockito.verifyNoMoreInteractions(packageBusiness, restaurantBusiness);
	}
	
	@Test
	public void shouldThrowAgencyExceptionAtListRestaurants() throws AgencyException {
		// given
		Pacote pacote = new Pacote();
		BDDMockito.given(packageBusiness.retrievePackage(PACKAGE_ID)).willReturn(pacote);
		BDDMockito.given(restaurantBusiness.listRestaurants(pacote)).willThrow(agencyException);

		// when
		catchException(restaurantServiceImpl).listRestaurants(PACKAGE_ID);

		// then
		BDDMockito.verify(packageBusiness).retrievePackage(PACKAGE_ID);
		BDDMockito.verify(restaurantBusiness).listRestaurants(pacote);
		BDDMockito.verifyNoMoreInteractions(packageBusiness, restaurantBusiness);
		assertThat(caughtException(), instanceOf(AgencyException.class));
	}
	
	@Test
	public void shouldThrowAgencyExceptionAtListRestaurantsWhenGetPackage() throws AgencyException {
		// given
		BDDMockito.given(packageBusiness.retrievePackage(PACKAGE_ID)).willThrow(agencyException);

		// when
		catchException(restaurantServiceImpl).listRestaurants(PACKAGE_ID);

		// then
		BDDMockito.verify(packageBusiness).retrievePackage(PACKAGE_ID);
		BDDMockito.verifyNoMoreInteractions(packageBusiness, restaurantBusiness);
		assertThat(caughtException(), instanceOf(AgencyException.class));
	}
	
	private Collection<Restaurante> buildRestaurants(){
		Collection<Restaurante> expectedRestaurants = new ArrayList<Restaurante>();
		Restaurante restaurante = new Restaurante();
		restaurante.setNome("Villa");
		expectedRestaurants.add(restaurante);
		return expectedRestaurants;
	}
}
