package fr.formation.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import fr.formation.dao.IDAOEtape;
import fr.formation.dao.IDAOModele;
import fr.formation.model.Etape;
import fr.formation.model.Modele;

@Controller
public class ModeleEtapeController {
	@Autowired
	private IDAOModele daoModele;

	@Autowired
	private IDAOEtape daoEtape;

	@GetMapping("/ModeleEtape")
	public String get(Model model, @RequestParam int id, HttpSession session) {

		model.addAttribute("etapes", daoEtape.findByModeleId(id));
		model.addAttribute("modele", daoModele.findById(id).get());
		session.setAttribute("modele", daoModele.findById(id).get());
		model.addAttribute("etape", new Etape());
		return ("ModeleEtape");
	}

	@PostMapping("/ModeleEtape")
	public String save(@ModelAttribute Etape etape, Model model, HttpSession session) {
		Modele modele = (Modele) session.getAttribute("modele");
		Etape et = daoEtape.findTopByOrderByIdDesc();
		etape.setModele(modele);
		etape.setId(et.getId() + 1);
		daoEtape.save(etape);
		model.addAttribute("etape", new Etape());
		return "redirect:ModeleEtape?id=" + modele.getId();
	}

	@GetMapping("/supModeleEtape")
	public String sup(@RequestParam int id, HttpSession session, Model model) {
		Modele modele = (Modele) session.getAttribute("modele");
		model.addAttribute("etapes", daoEtape.findByModeleId(modele.getId()));
		model.addAttribute("modele", modele);
		daoEtape.deleteById(id);
		return "redirect:ModeleEtape?id=" + modele.getId();
	}
	

	@GetMapping("/editModeleEtape")
	public String edit(@RequestParam int id, HttpSession session, Model model) {
		Modele modele = (Modele) session.getAttribute("modele");
		model.addAttribute("etape", daoEtape.findById(id).get());
		model.addAttribute("etapes", daoEtape.findByModeleId(modele.getId()));
		model.addAttribute("modele", modele);

		return "ModeleEtape";
	}

	@PostMapping("/editModeleEtape")
	public String editpost(@RequestParam int id,@RequestParam(name = "titre") String titre,@RequestParam(name="description") String descritption,@RequestParam(name="numero") int numero, @RequestParam(name="lien") String lien,HttpSession session, Model model) {
		Modele modele = (Modele) session.getAttribute("modele");
		
		Etape et = new Etape();
		et.setModele(modele);
		et.setDescription(descritption);
		et.setTitre(titre);
		et.setLien(lien);
		et.setNumero(numero);
		et.setId(id);
		daoEtape.save(et);
		model.addAttribute("etapes", daoEtape.findByModeleId(modele.getId()));
		model.addAttribute("modele", modele);
		model.addAttribute("etape", new Etape());

		return "redirect:ModeleEtape?id="+modele.getId();
	}

}
