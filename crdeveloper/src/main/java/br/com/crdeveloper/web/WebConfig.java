package br.com.crdeveloper.web;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;

import br.com.crdeveloper.config.DataConfig;

@Configuration
@EnableWebMvc
@ComponentScan( "br.com.crdeveloper" )
public class WebConfig extends WebMvcConfigurerAdapter implements ApplicationContextAware{

	private ApplicationContext applicationContext;
	
	public void setApplicationContext( ApplicationContext applicationContext ) throws BeansException{
		this.applicationContext = applicationContext;
	}
	
	
	@Bean
	public ViewResolver viewResolver( TemplateEngine templateEngine ){
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine( templateEngine );
		viewResolver.setCharacterEncoding( "UTF-8" );
		return viewResolver;
	}
	
	@Bean
	public TemplateEngine templateEngine( ITemplateResolver templateResolver ){
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setEnableSpringELCompiler( true );
		templateEngine.setTemplateResolver( templateResolver );
		return templateEngine;
	}
	
	
	@Bean
	public ITemplateResolver templateResolver(){
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext( applicationContext );
		templateResolver.setPrefix( "/WEB-INF/templates/" );
		templateResolver.setSuffix( ".html" );
		templateResolver.setTemplateMode( TemplateMode.HTML );
		return templateResolver;
	}
	
}
