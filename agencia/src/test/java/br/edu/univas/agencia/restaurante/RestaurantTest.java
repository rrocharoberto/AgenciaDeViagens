package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Restaurante;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class responsible by perform tests in the restaurant module.
 */
public class RestaurantTest {

    public RestaurantTest() {
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
     * Test of createRestaurant method, of class Restaurant.
     */
    @Test
    public void testCreateRestaurant() {

        try {
            System.out.println("Test createRestaurant method start...");
            Restaurante restaurant = null;
            RestaurantService restaurantService = new RestaurantService();
            Restaurante expResult = null;
            Restaurante result = restaurantService.createRestaurant(restaurant);
            assertEquals(expResult, result);
            System.out.println("Test createRestaurant method finish...");
        } catch (AgencyException e) {
            fail("Test fail. Cause: " + e.getMessage());
        }
    }

    /**
     * Test of updateRestaurant method, of class Restaurant.
     */
    @Test
    public void testUpdateRestaurant() {
    }

    /**
     * Test of removeRestaurant method, of class Restaurant.
     */
    @Test
    public void testRemoveRestaurant() {
    }

    /**
     * Test of getRestauranteById method, of class Restaurant.
     */
    @Test
    public void testGetRestauranteById() {
    }

    /**
     * Test of getRestaurantAll method, of class Restaurant.
     */
    @Test
    public void testGetRestaurantAll() {
    }

    /**
     * Test of getAvailableRestaurantList method, of class Restaurant.
     */
    @Test
    public void testGetAvailableRestaurantList() {
    }

    /**
     * Test of createReserve method, of class Restaurant.
     */
    @Test
    public void testCreateReserve() {
    }

    /**
     * Test of removeReserve method, of class Restaurant.
     */
    @Test
    public void testRemoveReserve() {
    }

    /**
     * Test of getReserveById method, of class Restaurant.
     */
    @Test
    public void testGetReserveById() {
    }

    /**
     * Test of getReserveAll method, of class Restaurant.
     */
    @Test
    public void testGetReserveAll() {
    }

}
