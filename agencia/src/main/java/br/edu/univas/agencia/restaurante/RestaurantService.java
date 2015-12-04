package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Restaurante;
import br.edu.univas.agencia.model.RestauranteReserva;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            
            Restaurante restaurante = repository.getById(restaurantId);
            restaurante.setId(restaurante.getId());
            restaurante.setNome(restaurante.getNome());
            restaurante.setNumeroVagas(restaurante.getNumeroVagas());
            restaurante.setRestauranteReservas(restaurante.getRestauranteReservas());
            restaurante.setValor(restaurante.getValor());
            restaurante.setCidade(restaurante.getCidade());
            restaurante.setActive(false);
            
            repository.updateRestaurant(restaurante);
            
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
        
        List<Restaurante> restaurants = new ArrayList<Restaurante>();
        
        try {
           //Recebendo um hashMap de restaurantes
            Map<Restaurante, Float> getRestaurants = repository.getRestaurantsAvailable(bundle);
            
            for (Map.Entry<Restaurante, Float> entry : getRestaurants.entrySet()) {
                Restaurante restaurante = entry.getKey();
                Float totalReservado = entry.getValue();
                
                //verifica quantas vagas o restaurante possui
                float vagas = restaurante.getNumeroVagas() - totalReservado;
                
                String dataInicio = String.valueOf(bundle.getDataInicio());
                String dataFim = String.valueOf(bundle.getDataFim());
                
                //recebe o número de dias do pacote
                int dias = contaDias(dataInicio, dataFim);
                
                //verifica a quantidade de vagas necessarias
                int vagasNecessarias = bundle.getQuantidadePessoas() * dias;
                
                //se o restaurante possui vagas suficiente ele é retornado
                if(vagas >= vagasNecessarias){
                    restaurants.add(restaurante);
                }  
            }
            
        } catch (Exception e) {
           throw new AgencyException("Houve uma falha ao buscar os restaurantes");
        }
        return restaurants;
    }
    
    /**
     * Método que pega a data inicial do pacote menos a data final e retorna o numero de dias corrido
     * @param dataInicial
     * @param dataFinal
     * @return
     * @throws ParseException 
     */
    public int contaDias(String dataInicial, String dataFinal) throws ParseException {  
		  
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");  
        df.setLenient(false);  
  
        Date dataInicio = null;
		try {
			dataInicio = df.parse(dataInicial);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        Date dataFim = null;
		try {
			dataFim = df.parse(dataFinal);
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        long dt = (dataFim.getTime() - dataInicio.getTime()) + 3600000;  
        long diasCorridosAnoLong = (dt / 86400000L);  
  
        String diasDecorridosInt = String.valueOf(diasCorridosAnoLong);  

        int diasDecorridos = Integer.parseInt(diasDecorridosInt);  
  
        return diasDecorridos;  
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
