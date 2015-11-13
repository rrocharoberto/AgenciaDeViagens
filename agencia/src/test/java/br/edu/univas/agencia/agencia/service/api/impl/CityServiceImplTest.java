package br.edu.univas.agencia.agencia.service.api.impl;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.univas.agencia.agencia.business.CityBusiness;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Cidade;

/**
 * Class for test {@link CityServiceImpl}.
 * 
 * @author edilson
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CityServiceImplTest {

	// Dependencies
	@Mock
	private CityBusiness cityBusiness;

	@Mock
	private AgencyException agencyException;

	// Target
	@InjectMocks
	private CityServiceImpl cityServiceImpl;

	@Test
	public void shouldListCities() throws AgencyException {
		// given
		Collection<Cidade> expectedCities = buildCities();
		given(cityBusiness.listCities()).willReturn(expectedCities);

		// when
		Collection<Cidade> result = cityServiceImpl.listCities();

		// then
		verify(cityBusiness).listCities();
		verifyNoMoreInteractions(cityBusiness);
		assertEquals(expectedCities, result);
	}

	@Test
	public void shouldThrowAgencyExceptionAtListCities() throws AgencyException {
		// given
		given(cityBusiness.listCities()).willThrow(agencyException);

		// when
		catchException(cityServiceImpl).listCities();

		// then
		verify(cityBusiness).listCities();
		verifyNoMoreInteractions(cityBusiness);
		assertThat(caughtException(), instanceOf(AgencyException.class));
	}

	private Collection<Cidade> buildCities() {
		Collection<Cidade> expectedCities = new ArrayList<Cidade>();
		Cidade cidade = new Cidade();
		cidade.setNome("Pouso Alegre");
		expectedCities.add(cidade);
		return expectedCities;
	}
}
