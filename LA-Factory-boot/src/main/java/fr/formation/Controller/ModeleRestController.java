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

import fr.formation.dao.IDAOModele;
import fr.formation.model.Modele;
import fr.formation.views.Views;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/modele")
public class ModeleRestController {
	
	@Autowired
	private IDAOModele daoModele;

	
	@GetMapping("/liste")
	@JsonView(Views.Modele.class)
	public List<Modele> get() {

		return this.daoModele.findAll();
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

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		daoModele.deleteById(id);
	}
}
