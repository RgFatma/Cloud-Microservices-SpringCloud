package org.opendevup.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class BourseRestService {

	@Value("${me}")
	private String message;
	
	@RequestMapping("/messages")
	public String tellMe(){
		System.out.println("*********************");
		System.out.println("C'est moi qui répond");
		System.out.println("*********************"); 
		return message;
	}
}
