package br.edu.univas.agencia.hotel;

import java.lang.reflect.Type;

import br.edu.univas.agencia.model.Hotel;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

/**
 * 
 * This class is responsible to provide the serialization of database objects,
 * turning them in JSON type.
 *
 * @implements {@link JsonSerializer<Hotel>}
 *
 */
public class HotelAdapter implements JsonSerializer<Hotel> {

	/**
	 * This method has the functionality to convert the objects coming from database in JSON
	 * This method is coming from {@link JsonSerializer} Interface.
	 * 
	 * @param {@link Hotel}, {@link Type} {@link JsonSerializationContext}
	 * 
	 * @return {@link JsonObject}
	 */
	@Override
	public JsonElement serialize(Hotel hotel, Type type, JsonSerializationContext jsc) {
		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("id", hotel.getId());
		jsonObject.addProperty("name", hotel.getNome());
		jsonObject.addProperty("value", hotel.getValor());
		jsonObject.addProperty("rooms", hotel.getNumeroVagas());
		jsonObject.addProperty("city", hotel.getCidade().getNome());
		jsonObject.addProperty("isActive", hotel.isActive());
		return jsonObject;
	}
}
