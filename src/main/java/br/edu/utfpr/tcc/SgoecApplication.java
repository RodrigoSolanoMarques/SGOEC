package br.edu.utfpr.tcc;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.jasperreports.JasperReportsMultiFormatView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsViewResolver;

@SpringBootApplication
public class SgoecApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgoecApplication.class, args);
	}
	
	@Bean
	public ViewResolver jasperReportsViewResolver(DataSource dataSource){
		JasperReportsViewResolver viewResolver = new JasperReportsViewResolver();
		viewResolver.setPrefix("classpath:/curriculo/");
		viewResolver.setSuffix(".jasper");
		viewResolver.setViewNames("relatorio_*");
		viewResolver.setViewClass(JasperReportsMultiFormatView.class);
		viewResolver.setJdbcDataSource(dataSource);
		
		return viewResolver;
	}
}
