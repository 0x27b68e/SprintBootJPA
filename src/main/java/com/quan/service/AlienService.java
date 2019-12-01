package com.quan.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface AlienService extends CrudRepository<Alien, Integer> {

}
