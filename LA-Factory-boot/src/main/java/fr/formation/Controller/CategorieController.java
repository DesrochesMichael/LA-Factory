package fr.formation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
//		model.addAttribute("categories", daoCategorie.findAll());

		return "listeCategorie";
	}

	@GetMapping("/ajoutCategorie")
	public String get(Model model) {
		model.addAttribute("categorie", new Categorie());
//		model.addAttribute("categories", daoCategorie.findAll());
		return "ajoutCategorie";
	}

	@PostMapping("/ajoutCategorie")
	public String save(@ModelAttribute Categorie categorie) {

		daoCategorie.save(categorie);

		return "redirect:listeCategorie";
	}

	@PostMapping("/editCategorie")
	public String saveedit(@ModelAttribute Categorie categorie) {

		daoCategorie.save(categorie);

		return "redirect:listeCategorie";
	}

	@GetMapping("/supCategorie")
	public String delete(@RequestParam int id) {
		daoCategorie.deleteById(id);

		return "redirect:listeCategorie";
	}

	@GetMapping("/editCategorie")
	public String update(@RequestParam int id, Model model) {
		model.addAttribute("categorie", daoCategorie.findById(id).get());
		return "ajoutCategorie";
	}
	
	@ModelAttribute("categories")
	public List<Categorie> getCategorie(){
		return daoCategorie.findAll();
	}
}
