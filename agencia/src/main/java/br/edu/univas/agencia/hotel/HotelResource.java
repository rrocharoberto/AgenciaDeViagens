package br.edu.univas.agencia.hotel;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;

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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import br.edu.univas.agencia.agencia.business.CityBusiness;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.Restaurante;


/**
 * 
 * Class that provides resources RESTful to Hotel module.
 *
 */
@Path("/root")
public class HotelResource {
	
	private HotelService hotelService = new HotelService();
	private Gson gson = new Gson();

	/**
	 * Redirect to the welcome page of the hotel system
	 * 
	 * URI = http://domain/agencia/api/hotel/root/home
	 * 
	 * Type = GET
	 * 
	 * @param res {@link HttpServletResponse}
	 * 
	 * @throws IOException
	 */
	@GET
	@Path("/home")
	@Produces({ MediaType.TEXT_PLAIN })
	public void index(@Context HttpServletResponse res) throws IOException {
		res.sendRedirect("/agencia/Hotel/Views/Home/index.html");
	}
	
	/**
	 * Redirect to the register page of the hotel system
	 * 
	 * URI = http://domain/agencia/api/hotel/root/register
	 * 
	 * Type = GET
	 * 
	 * @param res {@link HttpServletResponse}
	 * 
	 * @throws IOException
	 */
	@GET
	@Path("/register")
	@Produces({ MediaType.TEXT_PLAIN })
	public void register(@Context HttpServletResponse res) throws IOException {
		res.sendRedirect("/agencia/Hotel/Views/Register/index.html");
	}
	
	/**
	 * Redirect to the report page of the hotel system
	 * 
	 * URI = http://domain/agencia/api/hotel/root/report
	 * 
	 * Type = GET
	 * 
	 * @param res {@link HttpServletResponse}
	 * 
	 * @throws IOException
	 */
	@GET
	@Path("/report")
	@Produces({ MediaType.TEXT_PLAIN })
	public void report(@Context HttpServletResponse res) throws IOException {
		res.sendRedirect("/agencia/Hotel/Views/Report/index.html");
	}
	
	/**
	 * Resource to create hotel register.
     * 
     * URI = http://domain/agencia/api/hotel/root/create
     * 
     * Type = POST
	 * 
	 * @param name {@link FormParam} = Hotel name
	 * @param value {@link FormParam} = Hotel daily rate
	 * @param city {@link FormParam} = Hotel city
	 * @param rooms {@link FormParam} = Amount of hotel rooms
	 * @param isActive {@link FormParam} (flag) = Check if the hotel is active
	 * 
	 * @return {@link String} Response message of the AJAX request
	 * 
	 * @throws Exception
	 */
	@POST
	@Path("/create")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String create(@FormParam("name") String name,
					     @FormParam("value") Float value,
					     @FormParam("city") Integer city,
					     @FormParam("rooms") Integer rooms,
            		     @FormParam("isActive") boolean isActive) throws Exception {
		
		try{
			Hotel hotel = new Hotel();
			Cidade cidade = getCity(city);
			
			hotel.setNome(name);
			hotel.setValor(value);			
			hotel.setCidade(cidade);
			hotel.setNumeroVagas(rooms);
			hotel.setActive(isActive);
			hotelService.createHotel(hotel);
			
			return gson.toJson("O hotel foi cadastrado com sucesso");
		}catch(Exception ex){
			throw ex;
		}
	}
	
	/**
	 * Resource to get all registered hotels.
     * 
     * URI = http://domain/agencia/api/hotel/root/getAll
     * 
     * Type = GET
	 * 
	 * @return Object of type JSON converted to {@link String} with data of all hotels.
	 * 
	 * @throws Exception
	 */
	@GET
	@Path("/getAll")
	@Produces({ MediaType.APPLICATION_JSON })
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
	
	/**
	 * Resource that converts the {@link List<Hotel>} object to JSON object}.
	 * 
	 * @param hotelList {@link List<Hotel>}
	 * 
	 * @return Object of type JSON with all registered hotels
	 */
	public String hotelListToJson(List<Hotel> hotelList) {  
	    GsonBuilder gsonBuilder = new GsonBuilder();
	    Gson gson = gsonBuilder.registerTypeAdapter(Hotel.class, new HotelAdapter()).create();
	    return gson.toJson(hotelList);
	}
	
	/**
	 * Resource to edit edit a registered hotel.
     * 
     * URI = http://domain/agencia/api/hotel/root/edit
     * 
     * Type = POST
	 * 
	 * @param id {@link FormParam} = Hotel database id
	 * @param name {@link FormParam} = Hotel name
	 * @param value {@link FormParam} = Hotel daily rate
	 * @param city {@link FormParam} = Hotel city
	 * @param rooms {@link FormParam} = Amount of hotel rooms
	 * @param isActive {@link FormParam} (flag) = Check if the hotel is active
	 * 
	 * @return {@link String} Response message of the AJAX request
	 * @throws Exception
	 */
	@POST
	@Path("/edit")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String edit(@FormParam("id") Integer id,
						 @FormParam("name") String name,
					     @FormParam("value") Float value,
					     @FormParam("city") Integer city,
					     @FormParam("rooms") Integer rooms,
            		     @FormParam("isActive") boolean isActive) throws Exception {
		
		try{
			Hotel hotel = new Hotel();
			Cidade cidade = getCity(city);
			
			hotel.setId(id);
			hotel.setNome(name);
			hotel.setValor(value);
			hotel.setCidade(cidade);
			hotel.setNumeroVagas(rooms);
			hotel.setActive(isActive);
			hotelService.updateHotel(hotel);
			
			return gson.toJson("O hotel foi editado com sucesso");
		}catch(Exception ex){
			throw ex;
		}
	}
	
	/**
	 * Method responsible to call {@link HotelService}, to get one City by Id
	 * 
	 * @param {@link Integer} cityId
	 * 
	 * @return {@link Cidade}
	 * 
	 * @throws Exception
	 */
	private Cidade getCity(Integer cityId) throws Exception {
		try {
			return hotelService.getCityById(cityId);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
	/**
	 * Resource to edit a registered hotel.
     * 
     * URI = http://domain/agencia/api/hotel/root/delete
     * 
     * Type = POST
	 * 
	 * @param id {@link FormParam} = Hotel database id
	 * 
	 * @return {@link String} Response message of the AJAX request
	 * @throws Exception
	 */
	@POST
	@Path("/delete")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String delete(@FormParam("id") Integer id) throws Exception {
		
		try{
			if(id == null || id == 0) throw new AgencyException("Não é possível deletar o hotel!");
			hotelService.deleteHotel(id);
			
			return gson.toJson("O hotel foi deletado com sucesso");
		}catch(Exception ex){
			throw ex;
		}
	}
	
	/**
	 * Resource to get all cities are registered in database.
	 * 
	 * URI = http://domain/agencia/api/hotel/root/getCities
	 * 
	 * Type = GET
	 * 
	 * @return {@link String} Response message of the AJAX request
	 * 
	 * @throws Exception
	 */
	@GET
	@Path("/getCities")
	@Produces({ MediaType.APPLICATION_JSON })
	public String getCities() throws Exception {
		try {
			CityBusiness cityBusiness = new CityBusiness();
			Collection<Cidade> citiesList = cityBusiness.listCities();
			
			JsonArray jsonArray = new JsonArray();
			for (Cidade  city: citiesList) {
				JsonObject jsonObject = new JsonObject();
				jsonObject.addProperty("id", city.getId());
				jsonObject.addProperty("name", city.getNome());
				jsonArray.add(jsonObject);
			}
		    return gson.toJson(jsonArray);
		    
		} catch (Exception ex) {
			throw ex;
		}
	}
}
