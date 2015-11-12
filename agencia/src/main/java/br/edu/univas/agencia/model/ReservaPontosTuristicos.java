package br.edu.univas.agencia.model;

// Generated 11/11/2015 21:59:26 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * ReservaPontosTuristicos generated by hbm2java
 */
@Entity
@Table(name = "reserva_pontos_turisticos", catalog = "agencia")
public class ReservaPontosTuristicos implements java.io.Serializable {

	private Integer id;
	private Pacote pacote;
	private PontoTuristico pontoTuristico;
	private Date date;

	public ReservaPontosTuristicos() {
	}

	public ReservaPontosTuristicos(Pacote pacote,
			PontoTuristico pontoTuristico, Date date) {
		this.pacote = pacote;
		this.pontoTuristico = pontoTuristico;
		this.date = date;
	}

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
	@JoinColumn(name = "pacote_id", nullable = false)
	public Pacote getPacote() {
		return this.pacote;
	}

	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ponto_turistico", nullable = false)
	public PontoTuristico getPontoTuristico() {
		return this.pontoTuristico;
	}

	public void setPontoTuristico(PontoTuristico pontoTuristico) {
		this.pontoTuristico = pontoTuristico;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "date", nullable = false, length = 10)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
