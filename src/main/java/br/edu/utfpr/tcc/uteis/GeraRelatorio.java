package br.edu.utfpr.tcc.uteis;

import java.util.ArrayList;
import java.util.List;

import br.edu.utfpr.tcc.model.Curriculo;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class GeraRelatorio {

	// private String path; //Caminho base
	//
	// private String pathToReportPackage; // Caminho para o package onde estão
	// armazenados os relatorios Jarper
	//
	// //Recupera os caminhos para que a classe possa encontrar os relatórios
	// public GeraRelatorio() {
	// this.path = this.getClass().getClassLoader().getResource("").getPath();
	// this.pathToReportPackage = path.split("rhppp")[0] +
	// "rhppp/src/main/java/br/com/rhppp/relatorio/";
	// System.out.println(pathToReportPackage);
	// }
	//
	// //Imprime/gera uma lista de Curriculo
	// public void imprimir(List<Curriculo> curriculos) throws Exception {
	// JasperReport report =
	// JasperCompileManager.compileReport(this.getPathToReportPackage() +
	// "curriculoCandidato.jrxml");
	// JRDataSource jrds = new JRBeanCollectionDataSource(curriculos);
	// JasperPrint print = JasperFillManager.fillReport(report, null, jrds);
	// String caminho = path.split("rhppp")[0] +
	// "sgoec/src/main/webapp/resources/relatorios/curriculoCandidato.pdf";
	// JasperExportManager.exportReportToPdfFile(print, caminho);
	// }
	//
	// public String getPathToReportPackage() {
	// return this.pathToReportPackage;
	// }
	//
	// public String getPath() {
	// return this.path;
	// }
}
