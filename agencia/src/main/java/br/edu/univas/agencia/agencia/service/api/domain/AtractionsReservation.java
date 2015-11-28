package br.edu.univas.agencia.agencia.service.api.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.edu.univas.agencia.model.PontoTuristico;

@XmlRootElement
public class AtractionsReservation {

	private List<Atraction> atractions;

	public List<Atraction> getAtractions() {
		return atractions;
	}

	public void setAtractions(List<Atraction> atractions) {
		this.atractions = atractions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((atractions == null) ? 0 : atractions.hashCode());
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
		return true;
	}

}
