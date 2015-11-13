package br.edu.univas.agencia.agencia.service.api.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.edu.univas.agencia.agencia.service.api.PaymentService;
import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Cliente;
import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.Pagamento;

/**
 * Implementation of services defined in {@link PaymentService}.
 * 
 * @author edilson
 *
 */
@Path("/payment")
public class PaymentServiceImpl implements PaymentService {

	@GET
	@Override
	public List<Integer> listPaymentWay() throws AgencyException {
		// TODO return paymentBusiness.listPaymentWay();
		return null;
	}

	@Override
	public void createPayment(Pacote pacote, Cliente cliente,
			Pagamento pagamento) throws AgencyException {
		//TODO packageValidator.validatePackage();
		//TODO clientValidator.validateClient();
		//TODO paymentValidator.validatePayment();
		//TODO paymentBusiness.createPayment()

	}

}
