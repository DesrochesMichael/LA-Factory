package fr.formation.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Categorie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name = "id parent")
	private int idParent;
	
	@Column(name = "id enfant")
	private List<Integer> idEnfants;
	
	@Column(name = "nom", length = 25, nullable = false)
	private String nom;
	
	
	
}
