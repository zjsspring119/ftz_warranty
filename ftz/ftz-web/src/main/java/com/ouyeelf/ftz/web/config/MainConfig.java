package com.ouyeelf.ftz.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.ouyeelf.ftz.web.interceptor.ResourceHandlerInterceptorAdapter;

@Configuration
@EnableWebMvc
@Import({
		com.ouyeelf.ftz.web.config.WaxberryConfig.class,
		com.ouyeelf.ftz.service.config.ServiceConfig.class,
		com.ouyeelf.ftz.persist.config.MongoDBConfig.class,
		})
@ComponentScan(basePackages = { "com.bsteel.pacific.rc","com.waxberry" })
public class MainConfig  extends WebMvcConfigurationSupport{
	
	private static final String MESSAGES_SOURCE = "messages";
	private static final String VIEWS_PREF = "/WEB-INF/jsp/";
	private static final String VIEWS_SUFF = ".html";
	
	/**spring config **/
	
	@Bean(name = "messageSource")
	public ResourceBundleMessageSource resourceBundleMessageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename(MESSAGES_SOURCE);
		return messageSource;
	}
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix(VIEWS_PREF);
		resolver.setSuffix(VIEWS_SUFF);
		resolver.setOrder(2);
		return resolver;
	}
	
	@Bean
	public HandlerInterceptor handlerInterceptor(){
		return new ResourceHandlerInterceptorAdapter();
	}
	
	
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping(){
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();
		handlerMapping.setInterceptors(new HandlerInterceptor[]{handlerInterceptor()});
		handlerMapping.setOrder(0); 
		return handlerMapping;
	}
	
	
	
	/**
	 * org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter
	 */
	
	@SuppressWarnings("deprecation")
	@Bean
	public AnnotationMethodHandlerAdapter AnnotationMethodHandlerAdapter(){
		AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter= new AnnotationMethodHandlerAdapter();
		annotationMethodHandlerAdapter.setMessageConverters(new HttpMessageConverter[]{
				new StringHttpMessageConverter()
				,new MappingJacksonHttpMessageConverter()});
		return annotationMethodHandlerAdapter;
	}
	
}
