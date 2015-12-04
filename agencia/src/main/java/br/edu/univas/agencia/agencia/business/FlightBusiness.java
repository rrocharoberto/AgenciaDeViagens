package br.edu.univas.agencia.agencia.business;

import java.util.Collection;
import java.util.List;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Voo;
import br.edu.univas.agencia.model.VooReserva;
import br.edu.univas.agencia.voo.VooBean;

public class FlightBusiness {
	
	private final VooBean vooBean;
	
	public FlightBusiness() {
		this.vooBean = new VooBean();
	}

	public List<Integer> listFlightTypes(Pacote pacote) throws AgencyException {
		return null;
		
	}
	
	public Collection<Voo> listFlights(Pacote pacote) throws AgencyException {
		return vooBean.getVoos();
		
	}
	
	public void createFlightReservation(VooReserva vooReserva)
			throws AgencyException {
	}

}
