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

import fr.formation.dao.IDAOCategorie;
import fr.formation.model.Categorie;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/categorie")
public class CategorieRestController {

	
	@Autowired
	IDAOCategorie daoCategorie;

	
	@GetMapping
	public List<Categorie> get() {
		return daoCategorie.findAll();
	}

	@PutMapping("/{id}")
	public Categorie update(@RequestBody Categorie categorie) {
		daoCategorie.save(categorie);
		return categorie;
	}

	@PostMapping
	public Categorie save(@RequestBody Categorie categorie) {
		daoCategorie.save(categorie);
		return categorie;

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		daoCategorie.deleteById(id);
	}
}
