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
    
    RestaurantRepository repository;

    @Override
    public Restaurante createRestaurant(Restaurante restaurant) throws AgencyException {
        
        repository = new RestaurantRepository();
        
        try {
            
        } catch (Exception e) {
            new AgencyException("Houve uma falha ao inserir o restaurante");
        }
        
        return null;
    }

    @Override
    public void updateRestaurant(Restaurante restaurant) throws AgencyException {
        repository = new RestaurantRepository();
        
        try {
            
        } catch (Exception e) {
            new AgencyException("Houve uma falha ao inserir o restaurante");
        }
    }

    @Override
    public void removeRestaurant(Integer restaurantId) throws AgencyException {
        repository = new RestaurantRepository();
        
        try {
            
        } catch (Exception e) {
            new AgencyException("Houve uma falha ao inserir o restaurante");
        }
    }

    @Override
    public Restaurante getRestauranteById(Integer restaurantId) throws AgencyException {
        repository = new RestaurantRepository();
        
        try {
            
        } catch (Exception e) {
            new AgencyException("Houve uma falha ao inserir o restaurante");
        }
        return null;
    }

    @Override
    public List<Restaurante> getRestaurantAll() throws AgencyException {
        repository = new RestaurantRepository();
        
        try {
            
        } catch (Exception e) {
            new AgencyException("Houve uma falha ao inserir o restaurante");
        }
        return null;
    }

    @Override
    public List<Restaurante> getAvailableRestaurantList(Pacote bundle) throws AgencyException {
        repository = new RestaurantRepository();
        
        try {
            
        } catch (Exception e) {
            new AgencyException("Houve uma falha ao inserir o restaurante");
        }
        return null;
    }

    @Override
    public void createReserve(RestauranteReserva reserve) throws AgencyException {
        repository = new RestaurantRepository();
        
        try {
            
        } catch (Exception e) {
            new AgencyException("Houve uma falha ao inserir o restaurante");
        }
    }

    @Override
    public void removeReserve(Integer reserveId) throws AgencyException {
        repository = new RestaurantRepository();
        
        try {
            
        } catch (Exception e) {
            new AgencyException("Houve uma falha ao inserir o restaurante");
        }
    }

    @Override
    public RestauranteReserva getReserveById(Integer reserveId) throws AgencyException {
        repository = new RestaurantRepository();
        
        try {
            
        } catch (Exception e) {
            new AgencyException("Houve uma falha ao inserir o restaurante");
        }
        return null;
    }

    @Override
    public List<RestauranteReserva> getReserveAll() throws AgencyException {
        repository = new RestaurantRepository();
        
        try {
            
        } catch (Exception e) {
            new AgencyException("Houve uma falha ao inserir o restaurante");
        }
        return null;
    }

}
