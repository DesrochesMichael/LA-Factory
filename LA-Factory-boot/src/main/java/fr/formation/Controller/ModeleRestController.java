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
