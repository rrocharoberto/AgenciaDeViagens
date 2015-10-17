package br.edu.univas.agencia.hotel.service;

import br.edu.univas.agencia.model.AgencyException;

public interface IHotel {

	public HotelReservation reservRoom(ReservationInfo info) throws AgencyException;
	
	public HotelPrice queryPrice(HotelQuery queryInfo) throws AgencyException;

	public HotelAvaliability queryAvaliability(HotelQuery queryInfo) throws AgencyException;

	public Report generateReport(HotelReportQuery reportQuery) throws AgencyException;
	
}
