package fr.formation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/connexion")
	public String goConnexion() {
		return "connexion";
	}
	
	@PostMapping("/connexion")
	public String connexion() {
		return "home";
	}

}
