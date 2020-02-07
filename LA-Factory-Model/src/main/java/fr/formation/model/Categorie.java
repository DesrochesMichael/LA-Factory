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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdParent() {
		return idParent;
	}

	public void setIdParent(int idParent) {
		this.idParent = idParent;
	}

	public List<Integer> getIdEnfants() {
		return idEnfants;
	}

	public void setIdEnfants(List<Integer> idEnfants) {
		this.idEnfants = idEnfants;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	
}
