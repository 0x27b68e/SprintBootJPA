package com.quan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
