package fr.formation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.dao.IDAONote;
import fr.formation.model.Note;
import fr.formation.views.Views;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/note")
public class NoteRestController {
	
	@Autowired
	IDAONote daoNote;

	
	@GetMapping
	@JsonView(Views.Note.class)
	public List<Note> get() {
		return daoNote.findAll();
	}

//	@PutMapping("/{id}")
//	public Note update(@RequestBody Note note) {
//		daonote.save(note);
//		return note;
//	}
//
//	@PostMapping
//	public Note save(@RequestBody Note note) {
//		daonote.save(note);
//		return note;
//
//	}
//
//	@DeleteMapping("/{id}")
//	public void delete(@PathVariable int id) {
//		daonote.deleteById(id);
//	}
	

	
}
