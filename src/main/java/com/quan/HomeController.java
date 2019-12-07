package com.quan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quan.service.Alien;
import com.quan.service.AlienService;

@RestController
public class HomeController {
	
	@Autowired(required = true)
	AlienService alienService;
	
	@RequestMapping("/aliens")
	public Iterable<Alien>  getAliens() {
		Iterable<Alien> alien = alienService.findAll();
		return alien; // return data instead of view name as in MVC
	}
	
	@RequestMapping("/alien/{aid}")
	public Alien  getAlien(@PathVariable int aid) {
		Alien alien = alienService.findById(aid).orElse(null);
		return alien; // return data instead of view name as in MVC
	}

}
