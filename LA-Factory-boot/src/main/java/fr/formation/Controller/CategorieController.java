package fr.formation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.IDAOCategorie;

@Controller
public class CategorieController {

	@Autowired
	IDAOCategorie daoCategorie;

	@GetMapping("/listeCategorie")
	public String findall(Model model) {
		model.addAttribute("categories", daoCategorie.findAll());

		return "listeCategorie";
	}
}
