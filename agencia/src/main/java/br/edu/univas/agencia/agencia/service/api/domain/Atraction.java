package br.edu.univas.agencia.agencia.service.api.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

import br.edu.univas.agencia.model.Cidade;
import br.edu.univas.agencia.model.ReservaPontosTuristicos;

@XmlRootElement
public class Atraction {

	private Integer id;
	private Cidade cidade;
	private String descricao;
	private Integer numeroVagas;
	private Set<ReservaPontosTuristicos> reservaPontosTuristicoses = 
			new HashSet<ReservaPontosTuristicos>(0);
	
	private Map<String,Boolean> daysAvailable = new HashMap<String, Boolean>();

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getNumeroVagas() {
		return this.numeroVagas;
	}

	public void setNumeroVagas(Integer numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	public Set<ReservaPontosTuristicos> getReservaPontosTuristicoses() {
		return this.reservaPontosTuristicoses;
	}

	public void setReservaPontosTuristicoses(
			Set<ReservaPontosTuristicos> reservaPontosTuristicoses) {
		this.reservaPontosTuristicoses = reservaPontosTuristicoses;
	}

	public Map<String, Boolean> getDaysAvailable() {
		return daysAvailable;
	}

	public void setDaysAvailable(Map<String, Boolean> daysAvailable) {
		this.daysAvailable = daysAvailable;
	}
}
