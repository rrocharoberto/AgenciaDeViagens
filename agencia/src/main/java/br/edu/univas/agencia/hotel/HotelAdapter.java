package br.edu.univas.agencia.hotel;

import java.lang.reflect.Type;

import br.edu.univas.agencia.model.Hotel;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class HotelAdapter implements JsonSerializer<Hotel>{

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
