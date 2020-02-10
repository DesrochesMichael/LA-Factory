package fr.formation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.IDAOUtilisateur;

@Controller
public class UtilisateurController {

	@Autowired
	IDAOUtilisateur daoUtil;

	@GetMapping("/listeUtilisateur")
	public String findall(Model model) {
		model.addAttribute("utilisateurs", daoUtil.findAll());

		return "listeUtilisateur";
	}
}
