package br.edu.univas.agencia.service.api.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.univas.agencia.hotel.service.IHotel;
import br.edu.univas.agencia.model.AgencyException;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.service.api.HotelService;

@Path("/hotel")
public class HotelServiceImpl implements HotelService {

	private final IHotel iHotel;
	
	public HotelServiceImpl(IHotel iHotel) {
		this.iHotel = iHotel;
	}
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Hotel> findAll() throws AgencyException {
		List<Hotel> hotels = iHotel.findAll();
		
		return hotels;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Hotel findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Override
	public Hotel findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
