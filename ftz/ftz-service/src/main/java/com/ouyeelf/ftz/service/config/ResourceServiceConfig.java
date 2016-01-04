package com.ouyeelf.ftz.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ouyeelf.ftz.service.FtzWarrantyLogBeanService;
import com.ouyeelf.ftz.service.NStoreRecordBeanService;
import com.ouyeelf.ftz.service.ResourceService;
import com.ouyeelf.ftz.service.WarrantyBeanService;
import com.ouyeelf.ftz.service.WarrantySearchHisBeanService;
import com.ouyeelf.ftz.service.impl.FtzWarrantyLogBeanServiceImpl;
import com.ouyeelf.ftz.service.impl.NStoreRecordBeanServiceImpl;
import com.ouyeelf.ftz.service.impl.ResourceServiceImpl;
import com.ouyeelf.ftz.service.impl.WarrantyBeanServiceImpl;
import com.ouyeelf.ftz.service.impl.WarrantySearchHisBeanServiceImpl;
import com.waxberry.config.WaxberryBeanLoader;

@Configuration
public class ResourceServiceConfig {
	
	
	public @Bean 
	ResourceService resourceService(){
		return WaxberryBeanLoader.getBean(ResourceService.class, ResourceServiceImpl.class);
	}
	

	public @Bean 
	WarrantyBeanService warrantyBeanService(){
		return WaxberryBeanLoader.getBean(WarrantyBeanService.class, WarrantyBeanServiceImpl.class);
	}
	
	public @Bean
	NStoreRecordBeanService nStoreRecordBeanService(){
		return WaxberryBeanLoader.getBean(NStoreRecordBeanService.class, NStoreRecordBeanServiceImpl.class);
	}
	
	 public @Bean
	 WarrantySearchHisBeanService warrantySearchHisBeanService(){
		 
		 return WaxberryBeanLoader.getBean(WarrantySearchHisBeanService.class, WarrantySearchHisBeanServiceImpl.class);
	 }
	 public @Bean
	 FtzWarrantyLogBeanService ftzWarrantyLogBeanService(){
		 
		 return WaxberryBeanLoader.getBean(FtzWarrantyLogBeanService.class,FtzWarrantyLogBeanServiceImpl.class);
		 
	 }
	 
	 
}
