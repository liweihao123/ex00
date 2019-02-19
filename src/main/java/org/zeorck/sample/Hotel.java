package org.zeorck.sample;

import org.springframework.stereotype.Component;

import lombok.ToString;

@Component
public class Hotel {
	private Chef chef;
	private String name;
	
	public Hotel(Chef chef) {
		this.chef = chef;
	}
	
	public Chef getChef() {
		return chef;
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
