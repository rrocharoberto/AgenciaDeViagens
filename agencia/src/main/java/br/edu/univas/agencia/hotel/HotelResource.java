package br.edu.univas.agencia.hotel;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/root")
public class HotelResource {

	@GET
	@Path("/home")
	@Produces({ MediaType.TEXT_PLAIN })
	public void index(@Context HttpServletResponse res) throws IOException {
		res.sendRedirect("/agencia/Hotel/Views/Home/index.html");
	}
	
	@GET
	@Path("/register")
	@Produces({ MediaType.TEXT_PLAIN })
	public void register(@Context HttpServletResponse res) throws IOException {
		res.sendRedirect("/agencia/Hotel/Views/Register/index.html");
	}
	
	@GET
	@Path("/report")
	@Produces({ MediaType.TEXT_PLAIN })
	public void report(@Context HttpServletResponse res) throws IOException {
		res.sendRedirect("/agencia/Hotel/Views/Report/index.html");
	}
	
	@POST
	@Path("/create")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public void create(@FormParam("name") String name,
					   @FormParam("value") String value,
					   @FormParam("city") String city,
					   @FormParam("rooms") String rooms,
            		   @FormParam("isActive") String isActive) {

	}
}
