package com.quan.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface AlienService extends CrudRepository<Alien, Integer> {
	//pattern is findBy+NameOfProperty(Name)
	List<Alien> findByTech(String tech);
	
	//If we want to complex query, then we should use @Query
	@Query("from Alien where tech=?1 order by name")
	List<Alien> findByNameSorted(String tech);
}
