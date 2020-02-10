package fr.formation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOModele;

@Controller
public class ModelesController {
	
	@Autowired
	private IDAOModele daoModele;
	
	@GetMapping("/listeModeles")
	public String findAll(Model model) {
		model.addAttribute("modeles", daoModele.findAll());
		return "listeModeles";
	}
	
	@GetMapping("/detail/{modeleId}")
	public String getDetail(@PathVariable int id,
			Model model) {
		model.addAttribute(daoModele.findById(id));
		return null;
	}
}
