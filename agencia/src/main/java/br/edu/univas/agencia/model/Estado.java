package br.edu.univas.agencia.model;

// Generated 11/11/2015 21:59:26 by Hibernate Tools 3.4.0.CR1

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Estado generated by hbm2java
 */
@Entity
@Table(name = "estado", catalog = "agencia", uniqueConstraints = @UniqueConstraint(columnNames = "uf"))
@XmlRootElement
public class Estado implements java.io.Serializable {

	private Integer id;
	private String uf;
	private String nome;
	private Set<Cidade> cidades = new HashSet<Cidade>(0);

	public Estado() {
	}

	public Estado(String uf, String nome) {
		this.uf = uf;
		this.nome = nome;
	}

	public Estado(String uf, String nome, Set<Cidade> cidades) {
		this.uf = uf;
		this.nome = nome;
		this.cidades = cidades;
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

	@Column(name = "uf", unique = true, nullable = false, length = 2)
	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@Column(name = "nome", nullable = false, length = 50)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
	public Set<Cidade> getCidades() {
		return this.cidades;
	}

	public void setCidades(Set<Cidade> cidades) {
		this.cidades = cidades;
	}

}
