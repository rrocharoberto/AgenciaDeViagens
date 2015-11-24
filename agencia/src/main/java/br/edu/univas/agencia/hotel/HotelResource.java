package br.edu.univas.agencia.hotel;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/home")
public class HotelResource {

	@GET
	@Path("/index")
	@Produces({ MediaType.TEXT_PLAIN })
	public void index(@Context HttpServletResponse res) throws IOException {
		res.sendRedirect("/agencia/Hotel/Views/Home/index.html");
	}
}
