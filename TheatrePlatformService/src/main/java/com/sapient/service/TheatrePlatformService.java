package com.sapient.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import com.sapient.entity.TheatrePlatform;
import com.sapient.repository.TheatrePlatformRepository;
import com.sapient.request.TheatrePlatformRequest;
import com.sapient.response.ShowDetailsResponse;

import com.sapient.response.TheatrePlatformResponse;

import reactor.core.publisher.Mono;

@Service
public class TheatrePlatformService {

	@Value("${showDetaills.number}")
	private int showdetailsNumber;
	
	@Autowired
	TheatrePlatformRepository theatrePlatformRepository;
	
	@Autowired
	WebClient webClient;

	public TheatrePlatformResponse createThaetre(TheatrePlatformRequest theatrePlatformRequest) {

				
		TheatrePlatform tp = new TheatrePlatform();
		tp.setTheatreName(theatrePlatformRequest.getTheatreName());
		tp.setLocation(theatrePlatformRequest.getLocation());
		tp.setCity(theatrePlatformRequest.getCity());
		tp = theatrePlatformRepository.save(tp);
				
		TheatrePlatformResponse tpres = new TheatrePlatformResponse(tp);
		tpres.setId(getAddressById(tpres.getId()));
		return tpres;
	}
	
	public TheatrePlatformResponse getById (long id) {
		TheatrePlatform student = theatrePlatformRepository.findById(id).get();
		TheatrePlatformResponse studentResponse = new TheatrePlatformResponse(student);
		studentResponse.setId(getAddressById(showdetailsNumber));
		
		return studentResponse;
	}
	
	public ShowDetailsResponse getAddressById (long showId) {
		
		Mono<ShowDetailsResponse> addressResponse = 
				webClient.get().uri("/getById/" + showdetailsNumber)
		.retrieve().bodyToMono(ShowDetailsResponse.class);
		
			
		return addressResponse.block();
	}
}
