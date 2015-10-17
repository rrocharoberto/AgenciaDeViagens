package br.edu.univas.agencia.pagamento;

import br.edu.univas.agencia.model.AgencyException;

public interface IPayment {

	public void pay(PaymentInfo info) throws AgencyException;
	
	public void schedulePendency(ScheduleInfo info) throws AgencyException;

	public PaymentPendency queryPendency(PendencyQuery queryInfo) throws AgencyException;

	public Report generateReport(PaymentReportQuery reportQuery) throws AgencyException;
	
}
