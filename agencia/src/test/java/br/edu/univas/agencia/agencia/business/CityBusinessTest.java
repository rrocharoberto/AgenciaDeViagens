package br.edu.univas.agencia.agencia.business;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.univas.agencia.agencia.dao.CityDAO;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Cidade;

/**
 * Class for test {@link CityBusiness}.
 * 
 * @author edilson
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CityBusinessTest {

	// Dependencies
	@Mock
	private CityDAO cityDao;

	@Mock
	private EntityManager entityManager;

	@Mock
	private AgencyException agencyException;

	// Target
	@InjectMocks
	private CityBusiness cityBusiness;

	@Test
	public void shouldListCities() throws AgencyException {
		// given
		Collection<Cidade> cities = new ArrayList<Cidade>();
		BDDMockito.given(cityDao.getAll(entityManager)).willReturn(
				(List<Cidade>) cities);

		// when
		Collection<Cidade> result = cityBusiness.listCities();

		// then
		Assert.assertEquals(cities, result);
	}

	@Test
	public void shouldThrowAgencyExceptionAtListCities() throws AgencyException {
		// given
		given(cityDao.getAll(entityManager)).willThrow(agencyException);

		// when
		catchException(cityBusiness).listCities();

		// then
		verify(cityDao).getAll(entityManager);
		verifyNoMoreInteractions(cityDao);
		assertThat(caughtException(), instanceOf(AgencyException.class));
	}

}
