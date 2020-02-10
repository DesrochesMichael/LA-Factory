package fr.formation.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/note")
public class NoteRestController {
	
//	@Autowired
//	IDAONote daonote;
//
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
}
