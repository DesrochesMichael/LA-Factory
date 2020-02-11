package fr.formation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOCategorie;
import fr.formation.model.Categorie;
import fr.formation.views.Views;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/categorie")
public class CategorieRestController {

	
	@Autowired
	IDAOCategorie daoCategorie;

	
	@GetMapping
	@JsonView(Views.Categorie.class)
	public List<Categorie> get() {
		return daoCategorie.findAll();
	}
	
	@GetMapping("/findnom/{nom}")
	@JsonView(Views.Categorie.class)
	public List<Categorie> findByNom(@PathVariable String nom) {
		return daoCategorie.findByNom(nom);
	}
	
	@GetMapping("/findparent/{parent}")
	@JsonView(Views.Categorie.class)
	public List<Categorie> findByNom(@PathVariable int parent) {
		return daoCategorie.findByParent(daoCategorie.findById(parent).get());
	}

	@PutMapping("/update/{id}")
	@JsonView(Views.Categorie.class)
	public Categorie update(@RequestBody Categorie categorie) {
		daoCategorie.save(categorie);
		return categorie;
	}

	@PostMapping
	@JsonView(Views.Categorie.class)
	public Categorie save(@RequestBody Categorie categorie) {
		daoCategorie.save(categorie);
		return categorie;

	}

	@DeleteMapping("/{id}")
	@JsonView(Views.Categorie.class)
	public void delete(@PathVariable int id) {
		daoCategorie.deleteById(id);
	}
}
