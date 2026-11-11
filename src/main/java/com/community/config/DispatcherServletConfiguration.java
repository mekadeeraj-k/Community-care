package com.community.config;

import org.jspecify.annotations.Nullable;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class DispatcherServletConfiguration extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?> @Nullable [] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?> @Nullable [] getServletConfigClasses() {
		Class[] configClasses = {Configs.class};
		return configClasses;
	}

	@Override
	protected String[] getServletMappings() {
		String[] mappings = {"/community/*"};
		return mappings;
	}

}
