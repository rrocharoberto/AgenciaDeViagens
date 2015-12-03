package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Restaurante;
import br.edu.univas.agencia.model.RestauranteReserva;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class that implements interface {@link IRestaurant}. This class is
 * responsible by business logic to module of restaurant.
 */
public class RestaurantService implements IRestaurant {
    
    
    private RestaurantRepository repository;

    /**
     * Create construtor and initialize variables necessary for the operation of the class
     */
    public RestaurantService() {
        repository = new RestaurantRepository();
    }

    /**
     * Method responsible for saving the restaurant 
     */
    @Override
    public Restaurante createRestaurant(Restaurante restaurant) throws AgencyException {
      
        try {
            
            repository.createRestaurant(restaurant);
            
        } catch (Exception e) {
           throw new AgencyException("Não há nenhum restaurante para inserir");
        } 
               
        return null;
    }

    /**
     * Method resposible for for updating the restaurant
     * @param restaurant
     * @throws AgencyException 
     */
    @Override
    public void updateRestaurant(Restaurante restaurant) throws AgencyException {
        
        try {
            
           repository.updateRestaurant(restaurant); 
            
        } catch (Exception e) {
           throw new AgencyException("Não há restaurante para alterar");
        }
    }

    @Override
    public void removeRestaurant(Integer restaurantId) throws AgencyException {
        
        try {
            
            // fazer o updade, falta o campo na tabela
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao deletar o restaurante");
        }
    }

    /**
     * method responsible for seeking a restaurant by id
     * @param restaurantId
     * @return
     * @throws AgencyException 
     */
    @Override
    public Restaurante getRestauranteById(Integer restaurantId) throws AgencyException {
        
        try {
            
            repository.getById(restaurantId);
            
        } catch (Exception e) {
            throw new AgencyException("Não foi possível localizar o restaurante");
        }
        return null;
    }

    /**
     * method responsible for fetching all restaurants
     * @return
     * @throws AgencyException 
     */
    @Override
    public List<Restaurante> getRestaurantAll() throws AgencyException {
        
        try {
            
            repository.getAll();
            
        } catch (Exception e) {
            throw new AgencyException("Não foi possível listar nenhum restaurante");
        }
        return null;
    }

    /**
     * Method that behind all the restaurants and made ​​reservations
     * @param bundle
     * @return
     * @throws AgencyException 
     */
    @Override
    public List<Restaurante> getAvailableRestaurantList(Pacote bundle) throws AgencyException {
        
        try {
            
            // 9 seria numero de vagas prenchidas
            //new restaurante terei o a quantidade que ele comporta
            //numero de pessoas * o tempo
            
            Map<Restaurante, Integer> restaurantListReserved = new HashMap<Restaurante, Integer>();
            
            restaurantListReserved.put(new Restaurante(), 9);
            restaurantListReserved.put(new Restaurante(), 200);
            
            
            
            List<Restaurante> restaurants = new ArrayList<Restaurante>();
            
            List<Restaurante> getRestaurants = repository.getRestaurantsAvailable(bundle);
            
            for (Restaurante restaurant : getRestaurants) {
                
                
                
            }
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao buscar os restaurantes");
        }
        return null;
    }

    /**
     * Method accept responsibility for creating a reservation
     * @param reserve
     * @throws AgencyException 
     */
    @Override
    public void createReserve(RestauranteReserva reserve) throws AgencyException {
        
        try {
            
            repository.createRestaurantReservation(reserve);
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao criar a reserva");
        }
    }

    @Override
    public void removeReserve(Integer reserveId) throws AgencyException {
        
        try {
            
            // fazer o updade, falta o campo na tabela
            // Não tem medoto de alteração das reservas
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao remover a reserva");
        }
    }

    @Override
    public RestauranteReserva getReserveById(Integer reserveId) throws AgencyException {
        
        try {
            
            // falta o método de lista das reservas por id 
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao buscar esta reserva");
        }
        return null;
    }

    @Override
    public List<RestauranteReserva> getReserveAll() throws AgencyException {
        
        try {
            
            // falta o método de lista das reservas
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao buscar as reservas");
        }
        return null;
    }

}
