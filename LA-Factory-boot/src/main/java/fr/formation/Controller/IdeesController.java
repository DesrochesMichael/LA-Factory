package fr.formation.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOIdee;
import fr.formation.model.Idee;

@Controller
public class IdeesController {
	
	@Autowired
	IDAOIdee daoIdees;

	@GetMapping("/idees")
	public String idees(Model model) {
		model.addAttribute("idees", daoIdees.findByArchive(false));
		return "idees";
	}
	
	@GetMapping("/archiveIdee")
	public String delete(@RequestParam int ideeId) {
		Idee idee = daoIdees.findById(ideeId).orElse(null);
		idee.setArchive(true);
		daoIdees.save(idee);
		return "redirect:idees";
	}
}
