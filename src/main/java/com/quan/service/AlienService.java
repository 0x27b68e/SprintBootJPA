package com.quan.service;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface AlienService extends CrudRepository<Alien, Integer> {
	//pattern is findBy+NameOfProperty(Name)
	List<Alien> findByName(String name);
}
