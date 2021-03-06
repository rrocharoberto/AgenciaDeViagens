package br.edu.univas.agencia.pontos.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

import util.HibernateUtil;
import br.edu.univas.agencia.agencia.dao.CityDAO;
import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.PontoTuristico;
import br.edu.univas.agencia.pontos.pontosdao.PontosTuristicosDAO;

@ManagedBean(name = "pontosTuristicosController")
@ViewScoped
public class PontosTuristicosController {

	private List<PontoTuristico> pontosTuristicos;
	private List<Cidade> cidades;
	private PontosTuristicosDAO ptDAO;
	private CityDAO cityDao;
	
	private PontoTuristico pontoTuristico;
	private PontoTuristico pontoTurEdit;
	private PontoTuristico pontoTurDel;
	
	@PostConstruct
	public void init(){
		ptDAO = new PontosTuristicosDAO(HibernateUtil.getEntityManager());
		cityDao = new CityDAO();
		pontosTuristicos = ptDAO.listAllAttractions();
		cidades = cityDao.getAll(HibernateUtil.getEntityManager());
		pontoTuristico = new PontoTuristico();
	}
	
	public void addPontoTuristico(){
		ptDAO.addPontoTuristico(pontoTuristico);
		pontosTuristicos.add(pontoTuristico);
		
		RequestContext request = RequestContext.getCurrentInstance();
		request.execute("PF('addPonto').hide()");
		request.update("formAddPontos");
		pontoTuristico = new PontoTuristico();
		sendMessageToView("Ponto turístico adicionado com sucesso!", FacesMessage.SEVERITY_INFO);
	}
	
	public void updatePontoTuristico(){
		ptDAO.updateCostureira(pontoTurEdit);
		sendMessageToView("Ponto turístico atualizado com sucesso!", FacesMessage.SEVERITY_INFO);
		
		RequestContext request = RequestContext.getCurrentInstance();
		request.execute("PF('editPonto').hide()");
	}
	
	
	public void deletePontoTuristico() {

		try {
			ptDAO.removePontoTuristico(pontoTurDel);
			pontosTuristicos.remove(pontoTurDel);
			sendMessageToView("Ponto turístico removido com sucesso!",
					FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			sendMessageToView(
					"Este Ponto Turístico está relacionada com alguma reserva ou pacote e não pode ser excluído!",
					FacesMessage.SEVERITY_FATAL);
		}

	}
	
	public void loadPontoTuristicoToEdit(PontoTuristico pontoTuristico){
		pontoTurEdit = pontoTuristico;
	}
	
	public void loadPontoTuristicoToDelete(PontoTuristico pontoTuristico){
		pontoTurDel = pontoTuristico;
	}
	
	
	/*Messages Handling*/
	public void sendMessageToView(String message,Severity severity) {
		FacesContext contexto = FacesContext.getCurrentInstance();
		contexto.addMessage(null, new FacesMessage(severity, message, null));
	}
	
	/*GETTERS AND SETTERS*/
	public List<PontoTuristico> getPontosTuristicos() {
		return pontosTuristicos;
	}

	public void setPontosTuristicos(List<PontoTuristico> pontosTuristicos) {
		this.pontosTuristicos = pontosTuristicos;
	}

	public PontoTuristico getPontoTuristico() {
		return pontoTuristico;
	}

	public void setPontoTuristico(PontoTuristico pontoTuristico) {
		this.pontoTuristico = pontoTuristico;
	}

	public PontoTuristico getPontoTuristicoToEdit() {
		return pontoTurEdit;
	}

	public void setPontoTuristicoToEdit(PontoTuristico pontoTurEdit) {
		this.pontoTurEdit = pontoTurEdit;
	}

	public PontoTuristico getPontoTuristicoToDelete() {
		return pontoTurDel;
	}

	public void setPontoTuristicoToDelete(PontoTuristico pontoTurDel) {
		this.pontoTurDel = pontoTurDel;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

}
