package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Etape {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "id modele", nullable = false)
	private int idModele;
	
	@Column(name = "nom", length = 25, nullable = false)
	private String titre;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "numero", length = 25, nullable = false)
	private int numero;
	
	@Column(name = "lien", nullable = true)
	private String lien;
	
}
