package br.edu.univas.agencia.pontos.business;

import java.util.List;

import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.PontoTuristico;

public interface ITuristic {

	public List<PontoTuristico> getAvailableAttractions(Pacote pacote);

}
