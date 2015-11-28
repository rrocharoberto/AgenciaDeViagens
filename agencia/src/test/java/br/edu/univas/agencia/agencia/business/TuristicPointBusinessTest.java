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
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.PontoTuristico;
import br.edu.univas.agencia.pontos.business.impl.ITuristicImpl;

/**
 * Class for test {@link TuristicPointBusiness}.
 * 
 * @author edilson
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TuristicPointBusinessTest {
	
	private static final int PACKAGE_ID = 1;
	
	// Dependencies
	@Mock
	private ITuristicImpl ituristicImpl;
	
	@Mock
	private PackageBusiness packageBusiness;
	
	@Mock
	private Pacote pacote;
	
	@Mock
	private AgencyException agencyException;
	
	// Target
	@InjectMocks
	private TuristicPointBusiness turisticPointBusiness;
	
	@Test
	public void shouldListTuristicPoints() throws AgencyException, ParseException {
		// given
		List<PontoTuristico> pontos = new ArrayList<PontoTuristico>();
		given(packageBusiness.retrivePackage(PACKAGE_ID)).willReturn(pacote);
		given(ituristicImpl.getAvailableAttractions(pacote)).willReturn(pontos);
		
		// when
		List<PontoTuristico> result = turisticPointBusiness.listTuristicPoints(PACKAGE_ID);
		
		// then
		assertEquals(pontos, result);
	}
	
	@Test
	public void shouldThrowAgencyExceptionAtRetrieve() throws AgencyException, ParseException {
		// given
		given(packageBusiness.retrivePackage(PACKAGE_ID)).willThrow(agencyException);

		// when
		catchException(turisticPointBusiness).listTuristicPoints(PACKAGE_ID);

		// then
		verify(packageBusiness).retrivePackage(PACKAGE_ID);
		verifyNoMoreInteractions(packageBusiness, ituristicImpl);
		assertThat(caughtException(), instanceOf(AgencyException.class));
	}
	
	@Test
	public void shouldThrowAgencyExceptionAtListAtractions() throws AgencyException, ParseException {
		// given
		given(packageBusiness.retrivePackage(PACKAGE_ID)).willReturn(pacote);
		given(ituristicImpl.getAvailableAttractions(pacote)).willThrow(agencyException);
		// when
		catchException(turisticPointBusiness).listTuristicPoints(PACKAGE_ID);

		// then
		verify(packageBusiness).retrivePackage(PACKAGE_ID);
		verify(ituristicImpl).getAvailableAttractions(pacote);
		verifyNoMoreInteractions(packageBusiness, ituristicImpl);
		assertThat(caughtException(), instanceOf(AgencyException.class));
	}
}
