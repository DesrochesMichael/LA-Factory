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

import fr.formation.dao.IDAOModele;
import fr.formation.model.Modele;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/modele")
public class ModeleRestController {
	
	@Autowired
	IDAOModele daoModele;

	
	@GetMapping
	public List<Modele> get() {

		return daoModele.findAll();
	}
	
	@GetMapping("/find/{id}")
	public Modele findById(@PathVariable int id) {

		return daoModele.findById(id).get();
	}
	
//	@GetMapping("/categorie/{categorie}")
//	public List<Modele> findByCategorie(@PathVariable String categorie) {
//		return daoModele.findAllByCategorie(categorie);
//	}

	@PutMapping("/{id}")
	public Modele update(@RequestBody Modele modele) {
		daoModele.save(modele);
		return modele;
	}

	@PostMapping
	public Modele save(@RequestBody Modele modele) {
		daoModele.save(modele);
		return modele;

	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable int id) {
		daoModele.deleteById(id);
	}
}
