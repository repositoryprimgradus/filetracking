package com.pg.filetracking.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;
@Configuration

@ComponentScan(basePackages = "com.pg.*")

public class WebMvcConfigruation {

	 @Bean
	    public BCryptPasswordEncoder passwordencoder(){
	     return new BCryptPasswordEncoder();
	    }
	 

	 
	  @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }
}
