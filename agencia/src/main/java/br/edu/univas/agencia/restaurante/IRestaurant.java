package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Restaurante;
import br.edu.univas.agencia.model.RestauranteReserva;
import java.util.List;

/**
 * Interface that define methods of communication of module restaurant. This
 * methods controlling the registration of restaurants and reserves.
 *
 * @author Felipe Prado
 */
public interface IRestaurant {

    /**
     * Method responsible by controlling the creation of restaurants.
     *
     * @param restaurant {@link Restaurante}
     * @return {@link Restaurante} created
     * @throws AgencyException
     */
    public Restaurante createRestaurant(Restaurante restaurant) throws AgencyException;

    /**
     * Method responsible by controlling the update of restaurants.
     *
     * @param restaurant {@link Restaurante}
     * @throws AgencyException
     */
    public void updateRestaurant(Restaurante restaurant) throws AgencyException;

    /**
     * Method responsible by controlling the remove of restaurants.
     *
     * @param restaurantId Restaurant ID
     * @throws AgencyException
     */
    public void removeRestaurant(Integer restaurantId) throws AgencyException;

    /**
     * Method responsible by controlling the getting of restaurant by ID.
     *
     * @param restaurantId Restaurant ID
     * @return {@link Restaurante}
     * @throws AgencyException
     */
    public Restaurante getRestauranteById(Integer restaurantId) throws AgencyException;

    /**
     * Method responsible by controlling the getting of list all restaurants.
     *
     * @return List all {@link Restaurante}
     * @throws AgencyException
     */
    public List<Restaurante> getRestaurantAll() throws AgencyException;

    /**
     * Method responsible by controlling the getting of list restaurants.
     * available to reserve.
     *
     * @param bundle {@link Pacote}
     * @return List with {@link Restaurante} available to reserve
     * @throws AgencyException
     */
    public List<Restaurante> getAvailableRestaurantList(Pacote bundle) throws AgencyException;

    /**
     * Method responsible by controlling the creation of reserves of restaurant.
     *
     * @param reserve {@link  RestauranteReserva}
     * @throws AgencyException
     */
    public void createReserve(RestauranteReserva reserve) throws AgencyException;

    /**
     * Method responsible by controlling the remove of reserves of restaurant.
     *
     * @param reserveId Reserve ID
     * @throws AgencyException
     */
    public void removeReserve(Integer reserveId) throws AgencyException;

    /**
     * Method responsible by controlling the getting of reserve by ID.
     *
     * @param reserveId
     * @return {@link RestauranteReserva}
     * @throws AgencyException
     */
    public RestauranteReserva getReserveById(Integer reserveId) throws AgencyException;

    /**
     * Method responsible by controlling the getting of list all reserves.
     *
     * @return List all {@link RestauranteReserva}
     * @throws AgencyException
     */
    public List<RestauranteReserva> getReserveAll() throws AgencyException;

}
