package br.edu.univas.agencia.pagamento;

import java.io.IOException;

import br.edu.univas.agencia.exception.AgencyException;
import br.edu.univas.agencia.hotel.Consumes;
import br.edu.univas.agencia.hotel.Context;
import br.edu.univas.agencia.hotel.FormParam;
import br.edu.univas.agencia.hotel.GET;
import br.edu.univas.agencia.hotel.HttpServletResponse;
import br.edu.univas.agencia.hotel.POST;
import br.edu.univas.agencia.hotel.Path;
import br.edu.univas.agencia.hotel.Produces;
import br.edu.univas.agencia.model.Hotel;
import br.edu.univas.agencia.model.Pagamento;

@Path("/root")
public class PagamentoResource {
	
	private PagamentoService pagamentoService = new PagamentoService();
	
	@GET
	@Path("/home")
	@Produces({ MediaType.TEXT_PLAIN })
	public void index (@Context HttpServletResponse res) throws IOException{
		res.sendRedirect("/agencia/Pagamento/Views/Home/index.html");
	}

	@GET
	@Path("/register")
	@Produces({ MediaType.TEXT_PLAIN })
	public void register(@Context HttpServletResponse res) throws IOException {
		res.sendRedirect("/agencia/Hotel/Views/Register/index.html");
	}
	
	@GET
	@Path("/report")
	@Produces({ MediaType.TEXT_PLAIN })
	public void report(@Context HttpServletResponse res) throws IOException {
		res.sendRedirect("/agencia/Hotel/Views/Report/index.html");
	}
	
	@POST
	@Path("/create")
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON }
	public void create(@FormParam("pacote") Pacote pacote,
			   @FormParam("cliente") Cliente cliente,
			   @FormParam("formaPagamento") Integer formaPagamento) throws AgencyException {
		
		try{
			
			Pagamento pagamento = new Pagamento();
			pagamento.setCliente(cliente);
			pagamento.setPacote(pacote);
			pagamento.setFormaPagamento(formaPagamento);
			pagamentoService.pay(pagamento);
			
			return "O pagamento foi cadastrado com sucesso";
		}catch(Exception ex){
			throw new AgencyException("Não foi possível cadastrar o pagamento!");
		}
		
	}
	
}
