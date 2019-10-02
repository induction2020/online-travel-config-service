package com.cognizant.cloud.aws.online.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600,  allowedHeaders = "*")
@RefreshScope
@RestController
public class ConfigController {
	
	// Test : http://localhost:8091/admin-service/development
	
	@Autowired
	private Environment environment;
	
	@GetMapping
	public String checkAuth(){
		String serverPort = environment.getProperty("local.server.port");
		String git = environment.getProperty("spring.cloud.config.server.git.uri");
		String msg = environment.getProperty("msg");
		 
		System.out.println("ConfigController:   serverPort: "+serverPort);
		System.out.println("ConfigController:  git:  "+git); 
		return "Config Service : Port: "+serverPort; 
	}
	
	
	

}
