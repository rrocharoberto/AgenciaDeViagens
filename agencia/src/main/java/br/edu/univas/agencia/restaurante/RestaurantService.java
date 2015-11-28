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
    
    /**
     * Criando objeto da classe RestaurtRespository.
     */
    private RestaurantRepository repository = new RestaurantRepository();
    
    /**
     * Método responsável por criar restaurantes. 
     */
    @Override
    public Restaurante createRestaurant(Restaurante restaurant) throws AgencyException {
      
        try {
            
            repository.create(restaurant);
            
        } catch (NullPointerException e) {
           throw new AgencyException("Não há nenhum restaurante para inserir");
        } 
        
        
        return null;
    }

    @Override
    public void updateRestaurant(Restaurante restaurant) throws AgencyException {
        
        try {
            
           repository.update(restaurant); 
            
        } catch (NullPointerException e) {
           throw new AgencyException("Não há restaurante para alterar");
        }
    }

    @Override
    public void removeRestaurant(Integer restaurantId) throws AgencyException {
        
        try {
            
            
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao deletar o restaurante");
        }
    }

    @Override
    public Restaurante getRestauranteById(Integer restaurantId) throws AgencyException {
        
        try {
            
            repository.getById(restaurantId);
            
        } catch (NullPointerException e) {
            throw new AgencyException("Não foi possível localizar o restaurante");
        }
        return null;
    }

    @Override
    public List<Restaurante> getRestaurantAll() throws AgencyException {
        
        try {
            
            repository.getAll();
            
        } catch (NullPointerException e) {
            throw new AgencyException("Não foi possível listar nenhum restaurante");
        }
        return null;
    }

    @Override
    public List<Restaurante> getAvailableRestaurantList(Pacote bundle) throws AgencyException {
        
        try {
            
            repository.getRestaurantsAvailable(bundle);
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao buscar os restaurantes");
        }
        return null;
    }

    @Override
    public void createReserve(RestauranteReserva reserve) throws AgencyException {
        
        try {
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao criar a reserva");
        }
    }

    @Override
    public void removeReserve(Integer reserveId) throws AgencyException {
        
        try {
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao remover a reserva");
        }
    }

    @Override
    public RestauranteReserva getReserveById(Integer reserveId) throws AgencyException {
        
        try {
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao buscar esta reserva");
        }
        return null;
    }

    @Override
    public List<RestauranteReserva> getReserveAll() throws AgencyException {
        
        try {
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao buscar as reservas");
        }
        return null;
    }

}
