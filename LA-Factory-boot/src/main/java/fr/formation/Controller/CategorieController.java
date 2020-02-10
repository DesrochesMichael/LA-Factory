package fr.formation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOCategorie;
import fr.formation.model.Categorie;
import fr.formation.views.Views;

@Controller
public class CategorieController {

	@Autowired
	IDAOCategorie daoCategorie;

	@GetMapping("/listeCategorie")
	@JsonView(Views.Categorie.class)
	public String findall(Model model) {
		Categorie cat = new Categorie();
		model.addAttribute("cat", cat);
		model.addAttribute("categories", daoCategorie.findAll());

		return "listeCategorie";
	}
}
