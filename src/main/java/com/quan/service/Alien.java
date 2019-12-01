package com.quan.service;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
	
	
	public Alien() {
		super();
	}
	@Id
	private String aid;
	private String name;
	
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
