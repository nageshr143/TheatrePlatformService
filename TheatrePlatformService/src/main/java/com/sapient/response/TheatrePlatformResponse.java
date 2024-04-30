package com.sapient.response;

import javax.persistence.Column;

import com.sapient.entity.TheatrePlatform;

public class TheatrePlatformResponse {

	private long id;

	
	private String theatreName;
	public String getTheatreName() {
		return theatreName;
	}

	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	private String location;
	private String city;

	private ShowDetailsResponse showDetailsResponse;

	public ShowDetailsResponse getShowDetailsResponse() {
		return showDetailsResponse;
	}

	public void setShowDetailsResponse(ShowDetailsResponse showDetailsResponse) {
		this.showDetailsResponse = showDetailsResponse;
	}

	public TheatrePlatformResponse(TheatrePlatform student) {
		this.id = student.getId();
		this.theatreName = student.getTheatreName();
		this.location = student.getLocation();
		this.city = student.getCity();
	}

	public long getId() {
		return id;
	}

	public void setId(ShowDetailsResponse showDetailsResponse2) {
		this.showDetailsResponse = showDetailsResponse2;
	}

	
}
