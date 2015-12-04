package br.edu.univas.agencia.pontos.bean;

public class ReportBean {

	private String pontoTuristico;
	private int totalVisitas;
	
	public ReportBean(String pontoTuristico, int totalVisitas) {
		this.pontoTuristico = pontoTuristico;
		this.totalVisitas = totalVisitas;
	}
	
	@Override
	public String toString() {
		return "[{pontoTuristico:"+pontoTuristico+",totalVisitas:"+totalVisitas+"}]";
	}

	/*Getters and Setters*/
	public String getPontoTuristico() {
		return pontoTuristico;
	}
	public void setPontoTuristico(String pontoTuristico) {
		this.pontoTuristico = pontoTuristico;
	}
	public int getTotalVisitas() {
		return totalVisitas;
	}
	public void setTotalVisitas(int totalVisitas) {
		this.totalVisitas = totalVisitas;
	}
}
