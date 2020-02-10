package fr.formation.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.views.Views;

@Table
@Entity
public class Categorie {

	@Id
	@Column(name = "cat_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "cat_parent")
	@JsonView(Views.Common.class)
	private Categorie parent;
	
	@OneToMany(mappedBy="parent")
	@Cascade(CascadeType.ALL)
	@JsonView(Views.CategorieWithEnfants.class)
	private List<Categorie> enfants;
	
	@Column(name = "cat_nom", length = 25, nullable = false)
	@JsonView(Views.Categorie.class)
	private String nom;
	
	@ManyToMany(mappedBy = "categories")
	@JsonView(Views.CategorieWithModeles.class)
	Set<Modele> modeles;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Categorie getParent() {
		return parent;
	}

	public void setParent(Categorie parent) {
		this.parent = parent;
	}

	public List<Categorie> getEnfants() {
		return enfants;
	}

	public void setEnfants(List<Categorie> enfants) {
		this.enfants = enfants;
	}

	public Set<Modele> getModeles() {
		return modeles;
	}

	public void setModeles(Set<Modele> modeles) {
		this.modeles = modeles;
	}
	
	
	
}
