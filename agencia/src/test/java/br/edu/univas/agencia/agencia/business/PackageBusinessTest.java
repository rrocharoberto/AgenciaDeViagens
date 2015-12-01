package br.edu.univas.agencia.agencia.business;

import static com.googlecode.catchexception.CatchException.catchException;
import static com.googlecode.catchexception.CatchException.caughtException;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import util.HibernateUtil;
import br.edu.univas.agencia.agencia.dao.PackageDAO;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;

/**
 * Class for test {@link PackageBusiness}.
 * 
 * @author edilson
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class PackageBusinessTest {
	
	private static final int PACKAGE_ID = 1;
	private static final EntityManager ENTITY_MANAGER = HibernateUtil.getEntityManager();
	
	// Dependencies
	@Mock
	private PackageDAO packageDAO;
	
	@Mock
	private Pacote pacote;
	
	@Mock
	private AgencyException agencyException;
	
	// Target
	@InjectMocks
	private PackageBusiness packageBusiness;
	
	@Test
	public void shouldRetrievePackage() throws AgencyException {
		// given
		given(packageDAO.getById(PACKAGE_ID, ENTITY_MANAGER)).willReturn(pacote);
		
		// when
		Pacote result = packageBusiness.retrievePackage(PACKAGE_ID);
		
		// then
		assertEquals(pacote, result);
		
	}
	
	@Test
	public void shouldThrowAgencyExceptionAtRetrieve() throws AgencyException {
		// given
		given(packageDAO.getById(PACKAGE_ID, ENTITY_MANAGER)).willThrow(agencyException);

		// when
		catchException(packageBusiness).retrievePackage(PACKAGE_ID);

		// then
		verify(packageDAO).getById(PACKAGE_ID, ENTITY_MANAGER);
		verifyNoMoreInteractions(packageDAO);
		assertThat(caughtException(), instanceOf(AgencyException.class));
	}

}
