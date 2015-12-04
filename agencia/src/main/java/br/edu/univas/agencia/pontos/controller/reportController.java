package br.edu.univas.agencia.pontos.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.NavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import util.HibernateUtil;
import util.HttpRequestUtil;
import br.edu.univas.agencia.model.ReservaPontosTuristicos;
import br.edu.univas.agencia.pontos.bean.ReportBean;
import br.edu.univas.agencia.pontos.pontosDAO.PontosTuristicosDAO;

import com.google.gson.Gson;

@ManagedBean(name = "reportController")
@ViewScoped
public class reportController {

	private Date dataInicio;
	private Date dataFim;
	
	private String showDataInicio;
	private String showDataFim;

	private List<ReportBean> reportData;
	private String reportDataJson;
	PontosTuristicosDAO ptDAO;
	
	@PostConstruct
	public void init(){
		ptDAO = new PontosTuristicosDAO(HibernateUtil.getEntityManager());
		getFilterInformation();
		getReport();
	}
	
	public void getReport(){
		List<ReservaPontosTuristicos> reservas = null;
		reservas = ptDAO.getVisitedAttractions(dataInicio, dataFim);
		buildReport(reservas);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		showDataInicio = sdf.format(dataInicio);  
		showDataFim = sdf.format(dataFim);  
	}
	
	public void updateReport(){
		 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		 String dataIni = sdf.format(dataInicio);  
		 String dataFinal = sdf.format(dataFim);  
		
		FacesContext context = FacesContext.getCurrentInstance();
	     NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
	     navigationHandler.handleNavigation(context, null, "/PontosTuristicos/pages/report.xhtml?faces-redirect=true"+
	     "&amp;dateFrom="+dataIni+"&amp;dateTo="+dataFinal);
	}
	
	public void buildReport(List<ReservaPontosTuristicos> reservas){
		Map<String,ReportBean> mapAux = new HashMap<String,ReportBean>();
		reportData = new ArrayList<ReportBean>();
		ReportBean reportBean = null;
		
		for(ReservaPontosTuristicos rpt : reservas){
			String descricaoPT = rpt.getPontoTuristico().getDescricao();
			int qtdePessoas = rpt.getPacote().getQuantidadePessoas();
			
			if(mapAux.get(descricaoPT) == null){
				reportBean = new ReportBean(descricaoPT, qtdePessoas);
				mapAux.put(descricaoPT, reportBean);
				reportData.add(reportBean);
			}else{
				reportBean = mapAux.get(descricaoPT);
				int oldValue = reportBean.getTotalVisitas();
				reportBean.setTotalVisitas(oldValue + qtdePessoas);
			}
		}
		buildJson(reportData);
	}
	
	public void buildJson(List<ReportBean> reportData){
		Gson gson = new Gson();
		reportDataJson = gson.toJson(reportData);
	}
	
	public void getFilterInformation(){
		  Object dateFrom     = HttpRequestUtil.getParameterValueInRequest("dateFrom");
		  Object dateTo     = HttpRequestUtil.getParameterValueInRequest("dateTo");
		  
		try {
			if (dateFrom != null) {
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				dataInicio = (Date) formatter.parse(String.valueOf(dateFrom));
			} else {
				Calendar cal = Calendar.getInstance();
				dataInicio = cal.getTime();
			}
			
			if (dateTo != null) {
				DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				dataFim = (Date) formatter.parse(String.valueOf(dateTo));
			} else {
				Calendar cal = Calendar.getInstance();
				dataFim = cal.getTime();
			}

		} catch (ParseException e) {
			e.printStackTrace();
			Calendar cal = Calendar.getInstance();
			dataInicio = cal.getTime();
			dataFim = cal.getTime();
		}
	 }

	/*Getters and Setters*/
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	public String getShowDataInicio() {
		return showDataInicio;
	}

	public void setShowDataInicio(String showDataInicio) {
		this.showDataInicio = showDataInicio;
	}

	public String getShowDataFim() {
		return showDataFim;
	}

	public void setShowDataFim(String showDataFim) {
		this.showDataFim = showDataFim;
	}

	public String getReportDataJson() {
		return reportDataJson;
	}

	public void setReportDataJson(String reportDataJson) {
		this.reportDataJson = reportDataJson;
	}
}
