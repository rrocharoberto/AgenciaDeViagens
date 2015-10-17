package br.edu.univas.agencia.pontos;

import br.edu.univas.agencia.model.AgencyException;

public interface ITuristic {

	public void countEntrancies(EntranceInfo info) throws AgencyException;
	
	public LocationInfo queryLocation(LocationInfo info) throws AgencyException;

	public TuristicAvaliability queryAvaliability(TuristicQuery queryInfo) throws AgencyException;

	public Report generateReport(TuristicReportQuery reportQuery) throws AgencyException;
	
}
