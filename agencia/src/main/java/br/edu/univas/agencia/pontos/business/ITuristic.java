package br.edu.univas.agencia.pontos.business;

import java.util.List;

import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.PontoTuristico;

public interface ITuristic {

	/*public void countEntrancies(EntranceInfo info) throws AgencyException;
	
	public LocationInfo queryLocation(LocationInfo info) throws AgencyException;
*/
	public List<PontoTuristico> getAvailableAttractions(Pacote pacote);

	/*public Report generateReport(TuristicReportQuery reportQuery) throws AgencyException;*/
}
