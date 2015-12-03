package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.agencia.service.api.CityService;
import br.edu.univas.agencia.agencia.service.api.impl.CityServiceImpl;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.Restaurante;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

/**
 * Class that provides resources RESTful to restaurant module.
 */
@Path("")
public class RestaurantResource {

    private final IRestaurant restaurantService = new RestaurantService();

    /**
     * Resource to create restaurant register.
     * <br>
     * URI = http://domain/agencia/api/restaurant/create
     * <br>
     * Type = POST
     *
     * @param restaurantJSON JSON that represents object of type
     * {@link  Restaurante}
     * @param request {@link HttpServletRequest}
     * @return Object of type {@link Restaurante} converted to JSON with data of
     * restaurant.
     * @throws br.edu.univas.agencia.exception.AgencyException
     */
    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Restaurante create(JAXBElement<Restaurante> restaurantJSON, @Context HttpServletRequest request) throws AgencyException {

        try {
            Restaurante restaurant = restaurantJSON.getValue();
            restaurant = restaurantService.createRestaurant(restaurant);
            return restaurant;
        } catch (AgencyException e) {
            throw e;
        }
    }

    /**
     * Resource to update restaurant register.
     * <br>
     * URI = http://domain/agencia/api/restaurant/update
     * <br>
     * Type = POST
     *
     * @param restaurantJSON JSON that represents object of type
     * {@link  Restaurante}
     * @param request {@link HttpServletRequest}
     * @return Object of type {@link Restaurante} converted to JSON with data of
     * restaurant.
     * @throws br.edu.univas.agencia.exception.AgencyException
     */
    @Path("update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Restaurante update(JAXBElement<Restaurante> restaurantJSON, @Context HttpServletRequest request) throws AgencyException {

        try {
            Restaurante restaurant = restaurantJSON.getValue();
            restaurantService.updateRestaurant(restaurant);
            return restaurant;
        } catch (AgencyException e) {
            throw e;
        }
    }

    /**
     * Resource to get restaurant by ID
     * <br>
     * http://domain/agencia/api/restaurant/[restaurant id]
     * <br>
     *
     * @param restauranteId Restaurant ID
     * @param request {@link HttpServletRequest}
     * @return Object of type {@link Restaurante} converted to JSON with data of
     * restaurant.
     * @throws br.edu.univas.agencia.exception.AgencyException
     */
    @Path("{restaurantId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Restaurante getById(@PathParam("restaurantId") int restauranteId, @Context HttpServletRequest request) throws AgencyException {

        try {
            Restaurante restaurant = restaurantService.getRestauranteById(restauranteId);
            return restaurant;
        } catch (AgencyException e) {
            throw e;
        }
    }

    /**
     * Resource to get all restaurants.
     * <br>
     * http://domain/agencia/api/restaurant/all
     * <br>
     *
     * @param request {@link HttpServletRequest}
     * @return List objects of type {@link Restaurante} converted to JSON.
     * @throws br.edu.univas.agencia.exception.AgencyException
     */
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public RestaurantListTO getListAll(@Context HttpServletRequest request) throws AgencyException {

        try {
            RestaurantListTO restaurantListTO = new RestaurantListTO();
            restaurantListTO.setRestaurantList(restaurantService.getRestaurantAll());
            return restaurantListTO;
        } catch (AgencyException e) {
            throw e;
        }

    }

    /**
     * Resource to get list all city
     * <br>
     * http://domain/agencia/api/restaurant/city/list/all
     * <br>
     *
     * @param request {@link HttpServletRequest}
     * @return List objects of type {@link Cidade} converted to JSON.
     * @throws br.edu.univas.agencia.exception.AgencyException
     */
    @Path("city/list/all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CityListTO getCityList(@Context HttpServletRequest request) throws AgencyException {

        try {
            CityListTO cityListTO = new CityListTO();
            CityService cityServiceImpl = new CityServiceImpl();
            cityListTO.setCityList(cityServiceImpl.listCities());
            return cityListTO;
        } catch (AgencyException e) {
            throw e;
        }

    }
}
