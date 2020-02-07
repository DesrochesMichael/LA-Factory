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

import fr.formation.dao.IDAOEtape;
import fr.formation.model.Etape;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/etape")
public class EtapeRestController {

	@Autowired
	IDAOEtape daoEtape;

	
	@GetMapping
	public List<Etape> get() {
		return daoEtape.findAll();
	}

	@PutMapping("/{id}")
	public Etape update(@RequestBody Etape Etape) {
		daoEtape.save(Etape);
		return Etape;
	}

	@PostMapping
	public Etape save(@RequestBody Etape Etape) {
		daoEtape.save(Etape);
		return Etape;

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		daoEtape.deleteById(id);
	}
}
