package com.ouyeelf.ftz.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({
	com.ouyeelf.ftz.service.config.ResourceServiceConfig.class
	})
public class ServiceConfig {
//	public @Bean 
//	HelloWorldService helloWorldService(){
//		return WaxberryBeanLoader.getBean(HelloWorldService.class,HelloWorldServiceImpl.class);
//	}
//		
//	public @Bean 
//	CodesetService codesetService(){
//		return WaxberryBeanLoader.getBean(CodesetService.class,CodesetServiceImpl.class);
//	}
//	
//	public @Bean 
//	CustomerService customerService(){
//		return WaxberryBeanLoader.getBean(CustomerService.class, CustomerServiceImpl.class);
//	}
//	
//	public @Bean 
//	LfqmPdfInfService lfqmPdfInfService(){
//		return WaxberryBeanLoader.getBean(LfqmPdfInfService.class, LfqmPdfInfServiceImpl.class);
//	}
//	
//	public @Bean 
//	UserService userService(){
//		return WaxberryBeanLoader.getBean(UserService.class, UserServiceImpl.class);
//	}
//	
//	public @Bean 
//	CdnService cdnService(){
//		return WaxberryBeanLoader.getBean(CdnService.class, CdnServiceImpl.class);
//	}
//	
//	public @Bean 
//	LastModifiedService lastModifiedService(){
//		return WaxberryBeanLoader.getBean(LastModifiedService.class, LastModifiedServiceImpl.class);
//	}
}
