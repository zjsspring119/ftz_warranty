package com.ouyeelf.ftz.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.waxberry.spring.util.SpringContextUtil;

@Configuration
public class WaxberryConfig {
	
	/**waxberry**/
	
	public @Bean
	SpringContextUtil contextUtil(){
		return new SpringContextUtil();
	}
}
