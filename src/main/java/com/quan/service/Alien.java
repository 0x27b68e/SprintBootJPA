package com.quan.service;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Alien {
	
	
	public Alien() {
		super();
	}
	@Id
	private int aid;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Alien [aid=");
		builder.append(aid);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}

}
