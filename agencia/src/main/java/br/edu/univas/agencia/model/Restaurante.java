package br.edu.univas.agencia.model;

// Generated 11/11/2015 21:59:26 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Restaurante generated by hbm2java
 */
@Entity
@Table(name = "restaurante", catalog = "agencia")
public class Restaurante implements java.io.Serializable {

	private Integer id;
	private Cidade cidade;
	private String nome;
	private int numeroVagas;
	private float valor;
	private Set<RestauranteReserva> restauranteReservas = new HashSet<RestauranteReserva>(
			0);

	public Restaurante() {
	}

	public Restaurante(Cidade cidade, String nome, int numeroVagas, float valor) {
		this.cidade = cidade;
		this.nome = nome;
		this.numeroVagas = numeroVagas;
		this.valor = valor;
	}

	public Restaurante(Cidade cidade, String nome, int numeroVagas,
			float valor, Set<RestauranteReserva> restauranteReservas) {
		this.cidade = cidade;
		this.nome = nome;
		this.numeroVagas = numeroVagas;
		this.valor = valor;
		this.restauranteReservas = restauranteReservas;
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
	@JoinColumn(name = "cidade_id", nullable = false)
	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Column(name = "nome", nullable = false, length = 100)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "numero_vagas", nullable = false)
	public int getNumeroVagas() {
		return this.numeroVagas;
	}

	public void setNumeroVagas(int numeroVagas) {
		this.numeroVagas = numeroVagas;
	}

	@Column(name = "valor", nullable = false, precision = 12, scale = 0)
	public float getValor() {
		return this.valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurante")
	public Set<RestauranteReserva> getRestauranteReservas() {
		return this.restauranteReservas;
	}

	public void setRestauranteReservas(
			Set<RestauranteReserva> restauranteReservas) {
		this.restauranteReservas = restauranteReservas;
	}

}
