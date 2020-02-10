package fr.formation.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.formation.dao.IDAOIdee;

@Controller
public class IdeesController {
	
	@Autowired
	IDAOIdee daoIdees;

	@GetMapping("/idees")
	public String idees(Model model) {
		model.addAttribute("idees", daoIdees.findAll());
		return "idees";
	}
}
