package br.edu.univas.agencia.service;

import br.edu.univas.agencia.model.AgencyException;

public interface IAgencia {
	
	public Package buildPackage() throws AgencyException;
	
	public TuristicInfo chooseTuristic() throws AgencyException;
	
	public HotelInfo chooseHotel(TuristicInfo info) throws AgencyException;
	
	public RestaurantInfo chooseRestaurant(TuristicInfo info) throws AgencyException;
	
	public FlyInfo chooseFly() throws AgencyException;
	
	public Client queryClientBy(int reserv) throws AgencyException;
	
	public void pay(PackageInfo info) throws AgencyException;
	
}
