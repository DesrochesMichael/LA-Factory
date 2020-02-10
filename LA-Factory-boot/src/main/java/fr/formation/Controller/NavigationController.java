package fr.formation.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class NavigationController {
	
	@GetMapping("/menuPrincipal")
	public String menuPrincipal() {
		return "menuPrincipal";
	}
}
