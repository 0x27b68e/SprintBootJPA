package com.quan;

import java.util.List;
import java.util.Optional;

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
	public List<Alien>  getAliens() {
		List<Alien> aliens = alienService.findAll();
		return aliens;
	}
	
	@RequestMapping("/alien/{aid}")
	public Alien  getAlien(@PathVariable int aid) {
		Alien alien = alienService.findById(aid).orElse(null);
		Optional<Alien> findById = alienService.findById(aid);
		System.out.println(findById);
		return alien;
	}
	
	@RequestMapping("/delete/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		alienService.deleteById(aid);
		return aid + " have been delete successfully";
	}

}
