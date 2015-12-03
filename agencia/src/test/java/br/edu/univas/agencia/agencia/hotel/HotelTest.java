package br.edu.univas.agencia.agencia.hotel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.hotel.HotelService;
import br.edu.univas.agencia.model.Hotel;

public class HotelTest {
	
	public HotelTest(){
		
	}
	
	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	/**
	 *
	 */
	@Test
	public void testCreateHotel(){
		try{
			System.out.println("starting method create Hotel");
			Hotel hotel = null;
			HotelService hservice = new HotelService();
			Hotel expectResult = null;
			Hotel result = hservice.createHotel(hotel);
			assertEquals(expectResult, result);
			System.out.println("Test createRestaurant method finish...");
		} catch (AgencyException e) {
			fail("Test fail. Cause: " + e.getMessage());
		}
	}

}








