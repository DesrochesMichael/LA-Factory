package fr.formation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOEtape;
import fr.formation.dao.IDAOModele;
import fr.formation.model.Modele;

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
	
	@GetMapping("/detail/{modeleId}")
	public String getDetail(@PathVariable int id,
			Model model) {
		model.addAttribute(daoModele.findById(id));
		return null;
	}
	
	@PostMapping("/listeModeles")
	public String addModele(@ModelAttribute Modele modele) {
		daoModele.save(modele);
		return "redirect:listeModeles";
	}
	
	@GetMapping("/deleteModele")
	public String deleteModele(@RequestParam int id ) {
		daoModele.deleteById(id);
		return "redirect:/listeModeles";
	}
	
	@PostMapping("/editerModele")
	public String editModelePOST(@ModelAttribute Modele modele) {
		daoModele.save(modele);
		return "redirect:/listeModeles";
	}
	
	@GetMapping("/editerModele")
	public String editModeleGET(Model model,  @RequestParam int id) {
		Modele m = daoModele.findById(id).orElse(null);
		model.addAttribute("modele", m);
		return "listeModeles";
	}
	
	@GetMapping("/swipe")
	public String swipeAcivation(@RequestParam int id) {
		Modele modele = daoModele.findById(id).get();
		if(modele.getActivation()==null) {
			modele.setActivation(true);
		}
		else {
			boolean act=modele.getActivation();
			act=!act;
			modele.setActivation(act);
		}
		daoModele.save(modele);
		return "redirect:/listeModeles";
	}
}
