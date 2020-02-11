package fr.formation.Controller;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOModele;
import fr.formation.model.Modele;
import fr.formation.model.Note;
import fr.formation.views.Views;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/modele")
public class ModeleRestController {

	@Autowired
	private IDAOModele daoModele;

//	@GetMapping
//	@JsonView(Views.Modele.class)
//	public List<Modele> get() {
//
//		return this.daoModele.findAll();
//	}
	
	@GetMapping
	@JsonView(Views.Modele.class)
	public List<Modele> getActiver() {

		return this.daoModele.findByActivation(true);
	}

	@GetMapping("/findid/{id}")
	@JsonView(Views.ModeleWithNotes.class)
	public Modele findById(@PathVariable int id) {
		Modele m = daoModele.findById(id).get();
		Hibernate.initialize(m.getEtapes());
		return m;

	}

	@GetMapping("/findcategorie/{categorie}")
	@JsonView(Views.Modele.class)
	public List<Modele> findByCategorie(@PathVariable String categorie) {
		return daoModele.findByCategorie(categorie);
	}

	@GetMapping("/findnom/{nom}")
	@JsonView(Views.Modele.class)
	public List<Modele> findByNomContaining(@PathVariable String nom) {
		return daoModele.findByNomContaining(nom);
	}

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
