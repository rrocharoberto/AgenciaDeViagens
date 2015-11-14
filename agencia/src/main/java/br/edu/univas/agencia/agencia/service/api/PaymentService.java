package br.edu.univas.agencia.agencia.service.api;

import java.util.List;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Cliente;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Pagamento;

/**
 * Interface to define the services related to payment.
 * 
 * @author edilson
 *
 */
public interface PaymentService {

	List<Integer> listPaymentWay() throws AgencyException;

	void createPayment(Pacote pacote, Cliente cliente, Pagamento pagamento)
			throws AgencyException;

}
