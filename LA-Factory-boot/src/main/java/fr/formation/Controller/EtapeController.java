package fr.formation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOEtape;
import fr.formation.dao.IDAOModele;
import fr.formation.model.Etape;
import fr.formation.model.Modele;

@Controller
public class EtapeController {

	@Autowired
	IDAOEtape daoEtape;

	@Autowired
	IDAOModele daoModele;

	@GetMapping("/listeEtape")
	public String get(Model model) {
		model.addAttribute("etape", new Etape());
		model.addAttribute("etapes", daoEtape.findAll());
		return "listeEtape";
	}

	@ModelAttribute("modeles")
	public List<Modele> getModele() {
		return daoModele.findAll();
	}

	@PostMapping("/listeEtape")
	public String save(@ModelAttribute Etape etape) {

		daoEtape.save(etape);

		return "redirect:listeEtape";
	}

	@GetMapping("/supEtape")
	public String delete(@RequestParam int id) {
		daoEtape.deleteById(id);

		return "redirect:listeEtape";
	}

	@GetMapping("/editEtape")
	@Transactional
	public String update(@RequestParam int id, Model model) {
		model.addAttribute("etape", daoEtape.findById(id).get());
		model.addAttribute("etapes", daoEtape.findAll());
		return "listeEtape";
	}

	@PostMapping("/editEtape")
	public String saveedit(@ModelAttribute Etape etape) {

		daoEtape.save(etape);

		return "redirect:listeEtape";
	}
}
