package br.edu.univas.agencia.model;

// Generated 11/11/2015 21:59:26 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PontoTuristico generated by hbm2java
 */
@Entity
@Table(name = "ponto_turistico", catalog = "agencia")
public class PontoTuristico implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Cidade cidade;
	private String descricao;
	private Integer numeroVagas;
	private Set<ReservaPontosTuristicos> reservaPontosTuristicoses = 
			new HashSet<ReservaPontosTuristicos>(0);
	
	private Map<Date,Boolean> daysAvailable = new HashMap<Date, Boolean>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cidade_id", nullable = false)
	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Column(name = "descricao", nullable = false, length = 100)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "numero_vagas")
	public Integer getNumeroVagas() {
		return this.numeroVagas;
	}

	public void setNumeroVagas(Integer numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pontoTuristico")
	public Set<ReservaPontosTuristicos> getReservaPontosTuristicoses() {
		return this.reservaPontosTuristicoses;
	}

	public void setReservaPontosTuristicoses(
			Set<ReservaPontosTuristicos> reservaPontosTuristicoses) {
		this.reservaPontosTuristicoses = reservaPontosTuristicoses;
	}

	public Map<Date, Boolean> getDaysAvailable() {
		return daysAvailable;
	}

	public void setDaysAvailable(Map<Date, Boolean> daysAvailable) {
		this.daysAvailable = daysAvailable;
	}
	

}
