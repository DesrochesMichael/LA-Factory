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

import fr.formation.dao.IDAOUtilisateur;
import fr.formation.model.Utilisateur;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/utilisateur")
public class UtilisateurRestController {
	
	@Autowired
	IDAOUtilisateur daoUtilisateur;

	
	@GetMapping
	public List<Utilisateur> get() {
		return daoUtilisateur.findAll();
	}

	@PutMapping("/{id}")
	public Utilisateur update(@RequestBody Utilisateur Utilisateur) {
		daoUtilisateur.save(Utilisateur);
		return Utilisateur;
	}

	@PostMapping
	public Utilisateur save(@RequestBody Utilisateur Utilisateur) {
		daoUtilisateur.save(Utilisateur);
		return Utilisateur;

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		daoUtilisateur.deleteById(id);
	}

}
