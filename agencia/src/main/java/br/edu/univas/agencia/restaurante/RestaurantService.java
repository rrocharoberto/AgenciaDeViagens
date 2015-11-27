package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Restaurante;
import br.edu.univas.agencia.model.RestauranteReserva;
import java.util.List;

/**
 * Class that implements interface {@link IRestaurant}. This class is
 * responsible by business logic to module of restaurant.
 */
public class RestaurantService implements IRestaurant {

    @Override
    public Restaurante createRestaurant(Restaurante restaurant) throws AgencyException {
        //teste
        return null;
    }

    @Override
    public void updateRestaurant(Restaurante restaurant) throws AgencyException {
    }

    @Override
    public void removeRestaurant(Integer restaurantId) throws AgencyException {
    }

    @Override
    public Restaurante getRestauranteById(Integer restaurantId) throws AgencyException {
        return null;
    }

    @Override
    public List<Restaurante> getRestaurantAll() throws AgencyException {
        return null;
    }

    @Override
    public List<Restaurante> getAvailableRestaurantList(Pacote bundle) throws AgencyException {
        return null;
    }

    @Override
    public void createReserve(RestauranteReserva reserve) throws AgencyException {
    }

    @Override
    public void removeReserve(Integer reserveId) throws AgencyException {
    }

    @Override
    public RestauranteReserva getReserveById(Integer reserveId) throws AgencyException {
        return null;
    }

    @Override
    public List<RestauranteReserva> getReserveAll() throws AgencyException {
        return null;
    }

}
