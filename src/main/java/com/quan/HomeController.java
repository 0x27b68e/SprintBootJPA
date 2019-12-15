package com.quan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.quan.service.Alien;
import com.quan.service.AlienService;

@RestController
public class HomeController {
	
	@Autowired(required = true)
	AlienService alienService;
	 
	//This method will produce xml, not json
	//if we call request json from client, then 406 code will show, Not Acceptable
	@RequestMapping(path = "/aliens", produces = {"application/xml", "application/json"})
	public List<Alien>  getAliens() {
		List<Alien> aliens = alienService.findAll();
		return aliens;
	}
	
	@PostMapping(path = "/addAlien", consumes = {"application/json"}) // chỉ nhận data là json
	//Nếu data từ postman là raw, thì phải dùng @RequestBody
	public Alien  addAlien(@RequestBody Alien alien) {
		alienService.save(alien);
		return alien;
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
