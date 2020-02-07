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
import fr.formation.dao.IDAONote;
import fr.formation.model.Idee;
import fr.formation.model.Note;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/note")
public class NoteRestController {
	
	@Autowired
	IDAONote daonote;

	
	@GetMapping
	public List<Note> get() {
		return daonote.findAll();
	}

	@PutMapping("/{id}")
	public Note update(@RequestBody Note note) {
		daonote.save(note);
		return note;
	}

	@PostMapping
	public Note save(@RequestBody Note note) {
		daonote.save(note);
		return note;

	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		daonote.deleteById(id);
	}
}
