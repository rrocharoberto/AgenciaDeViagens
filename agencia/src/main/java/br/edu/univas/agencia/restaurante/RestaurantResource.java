package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.model.Restaurante;
import java.util.List;
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
     */
    @Path("create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Restaurante create(JAXBElement<Restaurante> restaurantJSON, @Context HttpServletRequest request) {
        return null; //TODO: not implemented.
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
     */
    @Path("update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Restaurante update(JAXBElement<Restaurante> restaurantJSON, @Context HttpServletRequest request) {
        return null; //TODO: not implemented.
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
     */
    @Path("{restaurantId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Restaurante getById(@PathParam("restaurantId") int restauranteId, @Context HttpServletRequest request) {
        return null; //TODO: not implemented.
    }

    /**
     * Resource to get all restaurants.
     * <br>
     * http://domain/agencia/api/restaurant/all
     * <br>
     *
     * @param request {@link HttpServletRequest}
     * @return List objects of type {@link Restaurante} converted to JSON.
     */
    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Restaurante> getAll(@Context HttpServletRequest request) {
        return null; //TODO: not implemented.
    }
}
