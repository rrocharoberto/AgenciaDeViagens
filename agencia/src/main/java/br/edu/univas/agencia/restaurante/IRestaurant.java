package br.edu.univas.agencia.restaurante;

import br.edu.univas.agencia.model.AgencyException;

public interface IRestaurant {

	public RestaurantReservation reservRoom(ReservationInfo info) throws AgencyException;
	
	public RestaurantPrice queryPrice(RestaurantQuery queryInfo) throws AgencyException;

	public RestaurantAvaliability queryAvaliability(RestaurantQuery queryInfo) throws AgencyException;

	public Report generateReport(RestaurantReportQuery reportQuery) throws AgencyException;
	
}
