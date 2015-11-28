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
import br.edu.univas.agencia.model.Restaurante;
import br.edu.univas.agencia.restaurante.IRestaurant;

@RunWith(MockitoJUnitRunner.class)
public class RestaurantBusinessTest {
	
	private static final int PACKAGE_ID = 1;
	
	// Dependencies
		@Mock
		private IRestaurant iRestaurant;
		
		@Mock
		private PackageBusiness packageBusiness;
		
		@Mock
		private Pacote pacote;
		
		@Mock
		private AgencyException agencyException;
	
		// Target
		@InjectMocks
		private Restaurante restaurantsBusiness;
		
	}
	
