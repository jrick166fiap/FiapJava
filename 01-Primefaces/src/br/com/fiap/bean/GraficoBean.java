package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.PieChartModel;

import br.com.fiap.bo.UsuarioBO;

@ManagedBean
public class GraficoBean {
	
	private PieChartModel graficoPizza;
	private LineChartModel graficoLinha;
	private UsuarioBO bo;
	
	@PostConstruct
	private void init(){
		bo = new UsuarioBO();
		
		// Grafico Pizza
		graficoPizza = new PieChartModel();
		graficoPizza.set("Abaixo de média", bo.contarUsuarioPorNivel(1)+bo.contarUsuarioPorNivel(2));
		graficoPizza.set("Normal", bo.contarUsuarioPorNivel(3));
		graficoPizza.set("Acima da Média", bo.contarUsuarioPorNivel(5)+bo.contarUsuarioPorNivel(4));
		
		
		graficoPizza.setLegendPosition("e");
		graficoPizza.setShowDataLabels(true);
		
		//Grafico Linha
		setGraficoLinha(new LineChartModel());
		getGraficoLinha().setLegendPosition("e");
		getGraficoLinha().setTitle("Vendas");
		getGraficoLinha().getAxes().put(AxisType.X, new CategoryAxis("Mês"));
		
		LineChartSeries serie1 = new LineChartSeries();
		serie1.setLabel("Alunos");
		
		String[] meses = {"Jan","Fev","Mar","Abr","Mai","Jun","Jul","Ago","Sem","Out","Nov","Dez"};
		for(int i = 1;i<12;i++){
			serie1.set(meses[i-1],bo.contarMesAniversariante(i));	
		}
		
		
       /*
		serie1.set("Janeiro",bo.contarMesAniversariante(1));
		serie1.set("Fevereiro",bo.contarMesAniversariante(2));
		serie1.set("Março",bo.contarMesAniversariante(3));
		serie1.set("Abril",bo.contarMesAniversariante(4));
		serie1.set("Maio",bo.contarMesAniversariante(5));
		serie1.set("Junho",bo.contarMesAniversariante(6));
		serie1.set("Julho",bo.contarMesAniversariante(7));
		serie1.set("Agosto",bo.contarMesAniversariante(8));
		*/
	
		
		//Tem que adicionar a serie ao gráfico.
		graficoLinha.addSeries(serie1);
	}
	

	public PieChartModel getGraficoPizza() {
		return graficoPizza;
	}

	public void setGraficoPizza(PieChartModel graficoPizza) {
		this.graficoPizza = graficoPizza;
	}


	public LineChartModel getGraficoLinha() {
		return graficoLinha;
	}


	public void setGraficoLinha(LineChartModel graficoLinha) {
		this.graficoLinha = graficoLinha;
	}
	

}
