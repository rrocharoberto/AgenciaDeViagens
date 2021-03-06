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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * RestauranteReserva generated by hbm2java
 */
@XmlRootElement
@Entity
@Table(name = "restaurante_reserva", catalog = "agencia")
public class RestauranteReserva implements java.io.Serializable {

	private Integer id;
	private Pacote pacote;
	private Restaurante restaurante;
	private Date dataReserva;

	public RestauranteReserva() {
	}

	public RestauranteReserva(Pacote pacote, Restaurante restaurante,
			Date dataReserva) {
		this.pacote = pacote;
		this.restaurante = restaurante;
		this.dataReserva = dataReserva;
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
	@JoinColumn(name = "restaurante_id", nullable = false)
	public Restaurante getRestaurante() {
		return this.restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data_reserva", nullable = false, length = 10)
	public Date getDataReserva() {
		return this.dataReserva;
	}

	public void setDataReserva(Date dataReserva) {
		this.dataReserva = dataReserva;
	}

}
