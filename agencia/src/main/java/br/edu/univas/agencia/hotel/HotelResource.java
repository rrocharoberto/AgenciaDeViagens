package br.edu.univas.agencia.hotel;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.Hotel;

@Path("/root")
public class HotelResource {
	
	private HotelService hotelService = new HotelService();
	private Gson gson = new Gson();

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
	@Produces({ MediaType.TEXT_PLAIN })
	public String create(@FormParam("name") String name,
					     @FormParam("value") Float value,
					     @FormParam("city") Integer city,
					     @FormParam("rooms") Integer rooms,
            		     @FormParam("isActive") boolean isActive) throws Exception {
		
		try{
			Hotel hotel = new Hotel();
			hotel.setNome(name);
			hotel.setValor(value);
			
			//TODO: getCityById()
			Cidade cidade = new Cidade();
			cidade.setId(1);
			
			hotel.setCidade(cidade);
			hotel.setNumeroVagas(rooms);
			hotel.setActive(isActive);
			hotelService.createHotel(hotel);
			
			return "O hotel foi cadastrado com sucesso";
		}catch(Exception ex){
			throw ex;
		}
	}
	
	@GET
	@Path("/getAll")
	@Produces({ MediaType.TEXT_PLAIN })
	public String getAll() throws Exception {
		try {
			
			List<Hotel> hotelList = hotelService.getAllHotel();
			String hotelJSON = hotelListToJson(hotelList);
			hotelJSON = "{ \"data\"" + " : " + hotelJSON + "}";
			return hotelJSON;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	public String hotelListToJson(List<Hotel> hotelList) {  
	    GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(Hotel.class, new HotelAdapter()).create();
	    return gson.toJson(hotelList);
	}
	
	@POST
	@Path("/edit")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	public String edit(@FormParam("id") Integer id,
						 @FormParam("name") String name,
					     @FormParam("value") Float value,
					     @FormParam("city") Integer city,
					     @FormParam("rooms") Integer rooms,
            		     @FormParam("isActive") boolean isActive) throws Exception {
		
		try{
			Hotel hotel = new Hotel();
			hotel.setId(id);
			hotel.setNome(name);
			hotel.setValor(value);
			
			//TODO: getCityById()
			Cidade cidade = new Cidade();
			cidade.setId(1);
			
			hotel.setCidade(cidade);
			hotel.setNumeroVagas(rooms);
			hotel.setActive(isActive);
			hotelService.updateHotel(hotel);
			
			return "O hotel foi editado com sucesso";
		}catch(Exception ex){
			throw ex;
		}
	}
	
	@POST
	@Path("/delete")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.TEXT_PLAIN })
	public String delete(@FormParam("id") Integer id) throws Exception {
		
		try{
			if(id == null || id == 0) throw new AgencyException("Não é possível deletar o hotel!");
			hotelService.deleteHotel(id);
			
			return "O hotel foi deletado com sucesso";
		}catch(Exception ex){
			throw ex;
		}
	}
}
