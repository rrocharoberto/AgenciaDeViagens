package br.edu.univas.agencia.model;

// Generated 11/11/2015 21:59:26 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * HotelReserva generated by hbm2java
 */
@Entity
@Table(name = "hotel_reserva", catalog = "agencia")
@XmlRootElement
public class HotelReserva implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Pacote pacote;
	private Hotel hotel;
	private Date dataReserva;

	public HotelReserva() {
	}

	public HotelReserva(Pacote pacote, Hotel hotel, Date dataReserva) {
		this.pacote = pacote;
		this.hotel = hotel;
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
	@JoinColumn(name = "hotel_id", nullable = false)
	public Hotel getHotel() {
		return this.hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
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
