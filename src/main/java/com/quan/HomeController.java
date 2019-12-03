package com.quan;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quan.service.*;

@Controller
public class HomeController {
	
	@Autowired(required = true)
	AlienService alienService;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String  addAlien(@ModelAttribute Alien alien) {
		
		Alien a = alienService.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView  getAlien(@RequestParam int aid) {
		ModelAndView modelAndView = new ModelAndView("showAlien.jsp");
		Alien alien = alienService.findById(aid).orElse(new Alien());
		modelAndView.addObject(alien);
		return modelAndView;
	}
	
	@RequestMapping("/getByName")
	public String getByName() {
		return "getAlienByName.jsp";
	}
	
	@RequestMapping("/getAlienByName")
	public ModelAndView  getAlienByName(@RequestParam String name) {
		ModelAndView modelAndView = new ModelAndView("showListAlien.jsp");
		List<Alien> aliens = alienService.findByName(name);
		System.out.println(aliens);
		modelAndView.addObject(aliens);
		return modelAndView;
	}

}
