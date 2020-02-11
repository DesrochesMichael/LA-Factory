package fr.formation.Controller;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOUtilisateur;
import fr.formation.model.Utilisateur;


@Controller
public class HomeController {
	
	@Autowired
	IDAOUtilisateur<Utilisateur> daoUtilisateur;

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/connexion")
	public String goConnexion() {
		return "connexion";
	}
	
	@PostMapping("/connexion")
	public String connexion(@Valid @ModelAttribute Utilisateur user,
			@RequestParam String mail,
			@RequestParam String password,
			HttpSession session
			) {
		if( daoUtilisateur.findByMailAndPassword(mail, password).orElse(null) == null ) {
			System.out.println("Vous avez entre un mot de passe ou email erronne");
			return "connexion";
		}
		else {
			int monId = daoUtilisateur.findByMailAndPassword(mail, password).get().getId();
			session.setAttribute("user", user.getNom());
			session.setAttribute("userId", monId);
			session.setAttribute("userRole", user.getRole());
			return "redirect:menuPrincipal";
		}
//		session.setAttribute("user", user.getNom());
//		session.setAttribute("userId", monId);
//		session.setAttribute("userRole", user.getRole());
//		return "redirect:menuPrincipal";
	}
	
	@GetMapping("/menuPrincipal")
	public String goMenu() {
		return "menuPrincipal";
	}
	
	@GetMapping("/creation")
	public String creation() {
		return "creation";
	}

}
