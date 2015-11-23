package br.edu.univas.agencia.hotel;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/index")
public class HotelResource {

	@GET
	@Produces({ MediaType.TEXT_PLAIN })
	public Response index() throws URISyntaxException {
		URI location = new URI("../../../../webapp/Hotel/Views/Home/index.html");
		return Response.temporaryRedirect(location).build();
	}
}
