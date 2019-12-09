package com.quan.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface AlienService extends JpaRepository<Alien, Integer> {
	
}
