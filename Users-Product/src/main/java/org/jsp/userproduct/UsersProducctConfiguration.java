package org.jsp.userproduct;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.jsp"})
public class UsersProducctConfiguration {
	 	
	 	 		@Bean
	 	 	       public EntityManager getManager() {
	 	 	    	   return Persistence.createEntityManagerFactory("dev").createEntityManager();
	 	 	       
	 	 	
	}




}
