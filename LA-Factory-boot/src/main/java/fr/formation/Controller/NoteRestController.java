package fr.formation.Controller;

import java.util.List;

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

//	
//	@GetMapping
//	public List<Note> get() {
//		return daonote.findAll();
//	}
//
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
	
	@GetMapping("/notemoyenne/{id}")
	@JsonView(Views.Modele.class)
	public void noteMoyenne(@PathVariable int id) {
		List<Note> notes = daoNote.findByModeleId(id);
		
		float noteMoyenne = 0;
		
		for(int i=0; i<notes.size(); i++) {
			noteMoyenne = noteMoyenne + notes.get(i).getValeur();
		}
	}
	
}
