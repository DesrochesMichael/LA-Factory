package fr.formation.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
public class ModeleEtapeController {
	@Autowired
	private IDAOModele daoModele;

	@Autowired
	private IDAOEtape daoEtape;

	@GetMapping("/ModeleEtape")
	public String get(Model model, @RequestParam int id, HttpSession session) {

		model.addAttribute("etapes", daoEtape.findByModeleId(id));
		model.addAttribute("modele", daoModele.findById(id).get());
		session.setAttribute("modele", daoModele.findById(id).get());
		model.addAttribute("etape", new Etape());
		return ("ModeleEtape");
	}

	@PostMapping("/ModeleEtape")
	public String save(@ModelAttribute Etape etape, Model model, HttpSession session) {
		Modele modele = (Modele) session.getAttribute("modele");

		etape.setModele(modele);

		daoEtape.save(etape);

		return "redirect:ModeleEtape?id=" + modele.getId();
	}
	
	@GetMapping("/editModeleEtape")
	public String edit(@RequestParam int id,HttpSession session, Model model) {
		Modele modele = (Modele) session.getAttribute("modele");
		model.addAttribute("etape", daoEtape.findById(id).get());
		model.addAttribute("etapes", daoEtape.findAll());//faite un findbyid avec une liste
		model.addAttribute("modele", modele);
		
		return "ModeleEtape";
	}

	
}
