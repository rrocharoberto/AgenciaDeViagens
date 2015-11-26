package br.edu.univas.agencia.agencia.business;

import java.util.Collection;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Restaurante;
import br.edu.univas.agencia.restaurante.RestaurantService;

public class RestaurantBussiness {
	
	private RestaurantService restaurantService;
	

	public RestaurantBussiness() {
		this.restaurantService = new RestaurantService();
	}


	public Collection<Restaurante> listRestaurants(Pacote pacote) throws AgencyException {
		return restaurantService.getAvailableRestaurantList(pacote);

	}

}
