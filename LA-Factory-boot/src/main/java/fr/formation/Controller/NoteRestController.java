package fr.formation.Controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAOModele;
import fr.formation.dao.IDAONote;
import fr.formation.model.Note;
import fr.formation.views.Views;

@CrossOrigin("*")
@RestController
@Transactional
@RequestMapping("/api/note")
public class NoteRestController {
	
	@Autowired
	IDAONote daonote;
	
	@Autowired
	IDAOModele daomodele;

	
	@GetMapping
	@JsonView(Views.Note.class)
	public List<Note> get() {
		return daonote.findAll();
	}
	
	@GetMapping("/id/{id}")
	@JsonView(Views.Note.class)
	public List<Note> findByModele(@PathVariable int id) {
		return daonote.findByModele(id);
	}
//
//	@PutMapping("/{id}")
//	public Note update(@RequestBody Note note) {
//		daonote.save(note);
//		return note;
//	}
//
	@PostMapping
	@JsonView(Views.Note.class)
	public Note save(@RequestBody Note note) {
		System.out.println(note.getModele().getId());
		daonote.save(note);
		return note;

	}
//
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable int id) {
//		daonote.deleteById(id);
//	}
}
