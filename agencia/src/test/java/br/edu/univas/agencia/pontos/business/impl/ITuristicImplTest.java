package br.edu.univas.agencia.pontos.business.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.edu.univas.agencia.model.Pacote;
import br.edu.univas.agencia.model.PontoTuristico;

@RunWith(MockitoJUnitRunner.class)
public class ITuristicImplTest {

	@Mock
	private PontoTuristico pontoTuristico;
	
	@InjectMocks
	private ITuristicImpl ituristTest;

	@Test
	public void shouldGetDaysOfPeriod() throws ParseException {
		// given
		Pacote pacote = new Pacote();
		pacote.setDataInicio(new Date("2015/01/01"));
		pacote.setDataFim(new Date("2015/01/03"));
		List<Date> daysOfPeriodExpected = new ArrayList<Date>();
		List<Date> daysOfPeriod = new ArrayList<Date>();
		
		Date data = new Date("2015/01/01");
		daysOfPeriodExpected.add(data);
		
		data = new Date("2015/01/02");
		daysOfPeriodExpected.add(data);
		
		data = new Date("2015/01/03");
		daysOfPeriodExpected.add(data);
		
		// when
		ituristTest.getDaysOfPeriod(pacote, daysOfPeriod);
		
		// then
		Assert.assertEquals(daysOfPeriodExpected, daysOfPeriod);
	}
}
