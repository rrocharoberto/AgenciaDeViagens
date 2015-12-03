package br.edu.univas.agencia.pagamento;

import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.model.Pagamento;

public class PagamentoService implements IPayment{

	public void pay(Pagamento pagamento) throws AgencyException {
		try {
			PagamentoDAO dao =  new PagamentoDAO();
			dao.salvar(pagamento);
		} catch (Exception e){
			System.out.print("Erro ao salvar o pagamento");
		}
	    
	}

	public List<Pagamento> getAllPagamento() throws AgencyException {
		List<Pagamento> pagamentoList = new ArrayList<Pagamento>();
		try {
			PagamentoDAO dao =  new PagamentoDAO();
			pagamentoList = dao.getAll();
		} catch (Exception e){
			System.out.print("Erro ao resgatar pagamentos");
		}
		return pagamentoList;
		
	}

}
