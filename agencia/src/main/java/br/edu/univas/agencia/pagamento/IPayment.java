package br.edu.univas.agencia.pagamento;

import java.util.List;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pagamento;

public interface IPayment {

	public void pay(Pagamento pagamento) throws AgencyException;
	
	public List<Pagamento> getAllPagamento() throws AgencyException;
	
}
