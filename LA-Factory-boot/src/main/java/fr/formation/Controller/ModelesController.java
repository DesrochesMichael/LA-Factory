package fr.formation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOCategorie;
import fr.formation.dao.IDAOEtape;
import fr.formation.dao.IDAOModele;
import fr.formation.model.Modele;
import fr.formation.model.Note;

@Controller
public class ModelesController {

	@Autowired
	private IDAOModele daoModele;

	@Autowired
	private IDAOEtape daoEtape;

	@Autowired
	private IDAOCategorie daoCategorie;

	@GetMapping("/listeModeles")
	public String findAll(Model model) {
		model.addAttribute("modeles", daoModele.findAll());
		return "listeModeles";
	}
}
