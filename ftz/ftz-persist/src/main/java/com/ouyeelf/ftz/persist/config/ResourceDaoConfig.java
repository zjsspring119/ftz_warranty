package com.ouyeelf.ftz.persist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ouyeelf.ftz.persist.dao.FtzWarrantyLogBeanDao;
import com.ouyeelf.ftz.persist.dao.NStoreRecordBeanDao;
import com.ouyeelf.ftz.persist.dao.ResourceDao;
import com.ouyeelf.ftz.persist.dao.WarrantyBeanDao;
import com.ouyeelf.ftz.persist.dao.WarrantySearchHisBeanDao;
import com.ouyeelf.ftz.persist.dao.impl.FtzWarrantyLogBeanDaoImp;
import com.ouyeelf.ftz.persist.dao.impl.NStoreRecordBeanDaoImpl;
import com.ouyeelf.ftz.persist.dao.impl.ResourceDaoImpl;
import com.ouyeelf.ftz.persist.dao.impl.WarrantyBeanDaoImp;
import com.ouyeelf.ftz.persist.dao.impl.WarrantySearchHisBeanDaoImpl;
import com.waxberry.config.WaxberryBeanLoader;

@Configuration
public class ResourceDaoConfig {

	public @Bean 
	ResourceDao resourceDao(){
		return WaxberryBeanLoader.getBean(ResourceDao.class, ResourceDaoImpl.class);
	}
	
	public @Bean 
	WarrantyBeanDao warrantyBeanDao(){
		return WaxberryBeanLoader.getBean(WarrantyBeanDao.class, WarrantyBeanDaoImp.class);
	}
	
	public @Bean 
	NStoreRecordBeanDao nStoreRecordBeanDao(){
		return WaxberryBeanLoader.getBean(NStoreRecordBeanDao.class, NStoreRecordBeanDaoImpl.class);
	}
	
	public @Bean
	WarrantySearchHisBeanDao WarrantySearchHisBeanDao(){
		return WaxberryBeanLoader.getBean(WarrantySearchHisBeanDao.class, WarrantySearchHisBeanDaoImpl.class);
		
	}
	
	public @Bean
	FtzWarrantyLogBeanDao FtzWarrantyLogBeanDao(){
		return WaxberryBeanLoader.getBean(FtzWarrantyLogBeanDao.class, FtzWarrantyLogBeanDaoImp.class);
	}
}

