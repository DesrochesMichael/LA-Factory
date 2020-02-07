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

import fr.formation.dao.IDAOIdee;
import fr.formation.model.Idee;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/idee")
public class IdeeRestController {

	
	@Autowired
	IDAOIdee daoidee;

	
	@GetMapping
	public List<Idee> get() {
		return daoidee.findAll();
	}

	@PutMapping("/{id}")
	public Idee update(@RequestBody Idee idee) {
		daoidee.save(idee);
		return idee;
	}

	@PostMapping
	public Idee save(@RequestBody Idee idee) {
		daoidee.save(idee);
		return idee;

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		daoidee.deleteById(id);
	}
}
