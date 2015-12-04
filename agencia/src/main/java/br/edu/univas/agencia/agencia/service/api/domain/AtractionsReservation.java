package br.edu.univas.agencia.agencia.service.api.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.PontoTuristico;

@XmlRootElement
public class AtractionsReservation {

	private List<Atraction> atractions;
	private Pacote pacote;

	public List<Atraction> getAtractions() {
		return atractions;
	}

	public void setAtractions(List<Atraction> atractions) {
		this.atractions = atractions;
	}
	
	public Pacote getPacote() {
		return pacote;
	}
	
	public void setPacote(Pacote pacote) {
		this.pacote = pacote;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((atractions == null) ? 0 : atractions.hashCode());
		result = prime * result + ((pacote == null) ? 0 : pacote.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AtractionsReservation other = (AtractionsReservation) obj;
		if (atractions == null) {
			if (other.atractions != null)
				return false;
		} else if (!atractions.equals(other.atractions))
			return false;
		if (pacote == null) {
			if (other.pacote != null)
				return false;
		} else if (!pacote.equals(other.pacote))
			return false;
		return true;
	}

	
}
