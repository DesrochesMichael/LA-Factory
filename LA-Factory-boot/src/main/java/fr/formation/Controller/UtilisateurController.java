package fr.formation.Controller;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

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
	public String get(Model model, HttpSession session) {
		Utilisateur user = daoUtil.findById((Integer) session.getAttribute("userId")).get();
		if(user.getRole().equals("ADMIN")) {
			model.addAttribute("utilisateur", new Utilisateur());
			return "ajoutUtilisateur";
		}
		else {
			return "listeUtilisateur";
		}
	}

	@PostMapping("/ajoutUtilisateur")
	public String save(@ModelAttribute Utilisateur utilisateur) {

		daoUtil.save(utilisateur);

		return "redirect:listeUtilisateur";
	}
	
	
	@PostMapping("/editUtilisateur")
	public String saveedit(@ModelAttribute Utilisateur utilisateur, HttpSession session) {
		Utilisateur user = daoUtil.findById((Integer) session.getAttribute("userId")).get();
		if(user.getRole().equals("ADMIN") || user.getNom().equals((String) utilisateur.getNom()) ) {
			daoUtil.save(utilisateur);
			return "redirect:listeUtilisateur";
		}
		else {
			return "redirect:listeUtilisateur";
		}
	}

	@GetMapping("/supUtilisateur")
	public String delete(@RequestParam int id, HttpSession session) {
		Utilisateur user = daoUtil.findById((Integer) session.getAttribute("userId")).get();
		if(user.getRole().equals("ADMIN")) {
			daoUtil.deleteById(id);
			return "redirect:listeUtilisateur";
		}
		else {
			return "redirect:listeUtilisateur";
		}
	}

	@GetMapping("/editUtilisateur")
	public String update(@RequestParam int id, Model model, HttpSession session) {
		Utilisateur changeUser = daoUtil.findById(id).get();
		Utilisateur user = daoUtil.findById((Integer) session.getAttribute("userId")).get();
		if(user.getRole().equals("ADMIN") || user.getNom().equals((String) changeUser.getNom()) ) {
			model.addAttribute("utilisateur", daoUtil.findById(id).get());
			return "ajoutUtilisateur";
		}
		else {
			return "redirect:listeUtilisateur";
		}
	}

}
