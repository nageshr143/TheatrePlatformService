package com.sapient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.request.TheatrePlatformRequest;
import com.sapient.response.TheatrePlatformResponse;
import com.sapient.service.TheatrePlatformService;

@RestController
@RequestMapping("/api/tps")
public class TheatrePlatformController {
	
	@Autowired
	TheatrePlatformService theatrePlatformService;
	
	@PostMapping("/createTheatrePlatform")
	public TheatrePlatformResponse createTheatrePlatform (@RequestBody TheatrePlatformRequest theatrePlatformRequest) {
		
		return theatrePlatformService.createThaetre(theatrePlatformRequest);
	}
	
	@GetMapping("getById/{id}")
	public TheatrePlatformResponse getById (@PathVariable long id) {
		return theatrePlatformService.getById(id);
	}
	
	
	  
	
	
}
