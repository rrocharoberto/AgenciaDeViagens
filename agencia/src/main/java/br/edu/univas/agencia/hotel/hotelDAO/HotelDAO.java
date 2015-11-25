package br.edu.univas.agencia.hotel.hotelDAO;

import java.util.List;

import javax.persistence.EntityManager;

import br.edu.univas.agencia.model.Hotel;

public class HotelDAO extends GenericHotelDAO<Hotel, Integer> {

	public HotelDAO(EntityManager em) {
		super(em);
	}

	public float getHotelPrice(Hotel hotel) {
		float valor = hotel.getValor();
		return valor;
	}

	public Integer getHotelAvaliability(Hotel hotel) {
		int resp=hotel.getNumeroVagas();
		return resp;
	}

	public List<Hotel> hotelReport(Hotel hotel) {
//		que tipo de relatório vai aqui???
		return null;
	}
}