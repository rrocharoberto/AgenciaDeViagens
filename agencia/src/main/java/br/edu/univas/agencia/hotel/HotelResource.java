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

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Hotel;

@Path("/root")
public class HotelResource {
	
	private HotelService hotelService = new HotelService();

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
					   @FormParam("value") Float value,
					   @FormParam("city") Integer city,
					   @FormParam("rooms") Integer rooms,
            		   @FormParam("isActive") boolean isActive) throws AgencyException {
		
		try{
			
			Hotel hotel = new Hotel();
			hotel.setNome(name);
			hotel.setValor(value);
			hotel.setCidade(null); //TODO: getCityById
			hotel.setNumeroVagas(rooms);
			hotel.setActive(isActive);
			hotelService.createHotel(hotel);
			
		}catch(Exception ex){
			throw new AgencyException("Não foi possível criar um novo hotel!");
		}
	}
}
