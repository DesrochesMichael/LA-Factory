package fr.formation.Controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOCategorie;
import fr.formation.dao.IDAOEtape;
import fr.formation.dao.IDAOModele;
import fr.formation.model.Categorie;
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

		List<Modele> modeles = daoModele.findAll();
		model.addAttribute("modeles", modeles);
		List<Modele> modelesMAJ = new ArrayList<Modele>();
		for (Modele m : modeles) {
			float res = 0;
			int tot = 0;
			List<Note> notes = m.getNotes();
			if (notes.size() > 0) {
				int i = notes.size();
				for (Note n : notes) {
					tot = tot + n.getValeur();
				}
				res = (float) tot / (float) i;
				m.setNoteMoy(res);
				modelesMAJ.add(m);
			}
			daoModele.saveAll(modelesMAJ);
		}
		model.addAttribute("categories", daoCategorie.findAll());
		return "listeModeles";
	}

	@PostMapping("/listeModeles")
	@Transactional
	public String addModele(@ModelAttribute Modele modele) {
		daoModele.save(modele);
		return "redirect:listeModeles";
	}

	@GetMapping("/deleteModele")
	public String deleteModele(@RequestParam int id, Model model) {
		daoModele.deleteById(id);
		model.addAttribute("modeles", daoModele.findAll());
		return "redirect:/listeModeles";
	}

	@PostMapping("/editerModele")
	public String editModelePOST(@ModelAttribute Modele modele) {
		daoModele.save(modele);
		return "redirect:/listeModeles";
	}

	@GetMapping("/editerModele")
	public String editModeleGET(Model model, @RequestParam int id) {
		Modele m = daoModele.findById(id).orElse(null);
		model.addAttribute("modele", m);
		model.addAttribute("modeles", daoModele.findAll());
		return "listeModeles";
	}

	@GetMapping("/swipe")
	public String swipeAcivation(@RequestParam int id) {
		Modele modele = daoModele.findById(id).get();
		if (modele.getActivation() == null) {
			modele.setActivation(true);
		} else {
			boolean act = modele.getActivation();
			act = !act;
			modele.setActivation(act);
		}
		daoModele.save(modele);
		return "redirect:/listeModeles";
	}
}
