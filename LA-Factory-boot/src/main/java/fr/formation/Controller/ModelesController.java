package fr.formation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOEtape;
import fr.formation.dao.IDAOModele;

@Controller
public class ModelesController {

	@Autowired
	private IDAOModele daoModele;

	@Autowired
	private IDAOEtape daoEtape;

	@GetMapping("/listeModeles")
	public String findAll(Model model) {
		model.addAttribute("modeles", daoModele.findAll());
		return "listeModeles";
	}

	

}
