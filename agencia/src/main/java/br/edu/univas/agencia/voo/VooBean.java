package br.edu.univas.agencia.voo;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import util.HibernateUtil;
import br.edu.univas.agencia.model.Voo;

@ManagedBean
@ViewScoped
public class VooBean {

	private EntityManager em = HibernateUtil.getEntityManager();
	private Voo voo = new Voo(); // TODO: mapeamento do voo
	private List<Voo> voos;
	private VooDAO vooDAO = new VooDAO();

	public String novoVoo() throws IOException {
		// super.novo(voo, em);
		vooDAO.novo(voo, em);
		return "";
	}

	public String atualizarVoo() {
		Voo new_voo = em.merge(voo);
		new_voo = voo;
		vooDAO.atualizar(new_voo, em);
		// super.atualizar(new_voo, em);
		return "";
	}

	public String deletarVoo(Voo voo) throws IOException {
		vooDAO.deletar(voo, em);
		// super.deletar(voo, em);
		return "";
	}

	@PostConstruct
	public void getAll() {
		// voos = super.getAll(em);
		voos = vooDAO.getAll(em);
	}

	public Voo getById(int id) {
		// return super.getById(id, em);
		return vooDAO.getById(id, em);
	}

	public Voo getVoo() {
		return voo;
	}

	public void setVoo(Voo voo) {
		this.voo = voo;
	}

	public List<Voo> getVoos() {
		return voos;
	}

	public void setVoos(List<Voo> voos) {
		this.voos = voos;
	}
}
