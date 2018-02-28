package org.opendevup;

import java.util.stream.Stream;


import org.opendevup.dao.SocieteRepository;
import org.opendevup.entities.Societe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@EnableEurekaClient
@SpringBootApplication
public class BourseSocieteServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BourseSocieteServiceApplication.class, args);
		
		//recupérer un Bean qui implemente cette interface
		SocieteRepository societeRepository=ctx.getBean(SocieteRepository.class);
		
		Stream.of("A","B","C").forEach(s->{
			societeRepository.save(new Societe(null,s));
		});
		
		societeRepository.findAll().forEach(s->{
			System.out.println(s.getId()+"   "+s.getNomSociete());
		});
		
	}
}
// Pour exposer les Ids   :http://localhost:8080/societes
@Configuration
class MyConfig extends RepositoryRestMvcConfiguration{
	
	//@Override
	protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config){
		config.exposeIdsFor(Societe.class);
	}
	
}
