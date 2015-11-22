package br.edu.univas.agencia.agencia.service.api;

import java.util.Collection;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.HotelReserva;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Restaurante;
import br.edu.univas.agencia.model.RestauranteReserva;

/**
 * Interface to define the services related to restaurant.
 * 
 * @author edilson
 *
 */
public interface RestaurantService {

	/**
	 * get the restaurant available.
	 * 
	 * @param pacote
	 * @return the list of restaurant available.
	 * @throws AgencyException
	 */
	Collection<Restaurante> listRestaurants(int packageId) throws AgencyException;

	/**
	 * create reservation for restaurant.
	 * 
	 * @param pacote
	 * @param restaurantReserva
	 * @throws AgencyException
	 */
	void createRestaurantReservation(RestauranteReserva restauranteReserva)
			throws AgencyException;
}
