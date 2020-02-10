package fr.formation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOUtilisateur;
import fr.formation.model.Utilisateur;

@Controller
public class UtilisateurController {

	@Autowired
	IDAOUtilisateur<Utilisateur> daoUtil;

	@GetMapping("/listeUtilisateur")
	public String findall(Model model) {
		model.addAttribute("utilisateurs", daoUtil.findAll());

		return "listeUtilisateur";
	}

	@GetMapping("/ajoutUtilisateur")
	public String get(Model model) {
		model.addAttribute("utilisateur", new Utilisateur());
		return "ajoutUtilisateur";
	}

	@PostMapping("/ajoutUtilisateur")
	public String save(@ModelAttribute Utilisateur utilisateur) {

		daoUtil.save(utilisateur);

		return "redirect:listeUtilisateur";
	}
	
	
	@PostMapping("/editUtilisateur")
	public String saveedit(@ModelAttribute Utilisateur utilisateur) {

		daoUtil.save(utilisateur);

		return "redirect:listeUtilisateur";
	}

	@GetMapping("/supUtilisateur")
	public String delete(@RequestParam int id) {
		daoUtil.deleteById(id);

		return "redirect:listeUtilisateur";
	}

	@GetMapping("/editUtilisateur")
	public String update(@RequestParam int id, Model model) {
		model.addAttribute("utilisateur", daoUtil.findById(id).get());
		return "ajoutUtilisateur";
	}

}
