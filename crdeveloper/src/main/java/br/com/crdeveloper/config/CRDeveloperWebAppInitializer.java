package br.com.crdeveloper.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import br.com.crdeveloper.web.WebConfig;

public class CRDeveloperWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{ RootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {	
		return new Class<?>[]{ WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{ "/" };
	}

}
