package fr.formation.model;

import java.sql.Time;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.model.Categorie;
import fr.formation.model.Etape;
import fr.formation.model.Niveau;
import fr.formation.model.Note;
import fr.formation.views.Views;

@Table
@Entity
public class Modele {
	@Id
	@Column(name = "modele_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@Column(name = "modele_niveau", nullable = false)
	@JsonView(Views.Modele.class)
	private Niveau niveau;
	
	@Column(name = "modele_nom", length = 25, nullable = false)
	@JsonView(Views.Modele.class)
	private String nom;
	
	@Column(name = "modele_temps", nullable = false)
	@JsonView(Views.Modele.class)
	private Time temps;
	
	@Column(name = "modele_bois",length = 25, nullable = false)
	@JsonView(Views.Modele.class)
	private int bois;
	
	@OneToMany(mappedBy="modele")
	@JsonView(Views.ModeleWithEtapes.class)
	private List<Etape> etapes;
	
	@OneToMany(mappedBy="modele")
	@JsonView(Views.ModeleWithNotes.class)
	private List<Note> notes;
	
	@Column(name = "modele_activ")
	@JsonView(Views.Modele.class)
	private Boolean activation;
	
	@ManyToMany(cascade = {
	        CascadeType.PERSIST,
	        CascadeType.MERGE})
	@JoinTable(name = "modele_categorie",
	        joinColumns = @JoinColumn(name = "modele_id"),
	        inverseJoinColumns = @JoinColumn(name = "cat_id"))
	@JsonView(Views.ModeleWithCategories.class)
	private Set<Categorie> categories;

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

	public Time getTemps() {
		return temps;
	}

	public void setTemps(Time temps) {
		this.temps = temps;
	}

	public int getBois() {
		return bois;
	}

	public void setBois(int bois) {
		this.bois = bois;
	}

	public List<Etape> getEtapes() {
		return etapes;
	}

	public void setEtapes(List<Etape> etapes) {
		this.etapes = etapes;
	}


	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Boolean getActivation() {
		return activation;
	}

	public void setActivation(Boolean activation) {
		this.activation = activation;
	}

	public Set<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(Set<Categorie> categories) {
		this.categories = categories;
	}

	
	
	
	
}
