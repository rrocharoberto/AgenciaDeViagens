package br.edu.univas.agencia.agencia.service.api.impl;

import static org.mockito.BDDMockito.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.univas.agencia.agencia.business.CityBusiness;
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
	
	// Target
	@InjectMocks
	private CityServiceImpl cityServiceImpl;
	
	@Test
	public void shouldRetrieveCity() {
		// given
		Collection<Cidade> expectedCities = new ArrayList<Cidade>();
		given(cityBusiness.retrieve()).willReturn(expectedCities);
		
		// when
		Collection<Cidade> result = cityServiceImpl.retrieve();
		
		// then
		assertEquals(expectedCities, result);
	}
}
