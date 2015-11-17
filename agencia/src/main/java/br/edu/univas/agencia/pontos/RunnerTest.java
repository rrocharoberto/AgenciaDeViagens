package br.edu.univas.agencia.pontos;

import java.text.ParseException;
import java.util.Date;

import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.pontos.business.impl.ITuristicImpl;

public class RunnerTest {

	public static void main(String[] args) {
		Pacote pacote = new Pacote();
		pacote.setDataInicio(new Date("2015/01/01"));
		pacote.setDataFim(new Date("2015/02/01"));
		
		ITuristicImpl teste = new ITuristicImpl();
		try {
			teste.getAvailableAttractions(pacote);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
