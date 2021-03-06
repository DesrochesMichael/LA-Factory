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

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.model.Categorie;
import fr.formation.model.Etape;
import fr.formation.model.Niveau;
import fr.formation.model.Note;
import fr.formation.views.Views;
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
	private int temps;
	
	@Column(name = "modele_bois",length = 25, nullable = false)
	@JsonView(Views.Modele.class)
	private int bois;
	
	@OneToMany(mappedBy="modele")
	@JsonView({Views.Modele.class, Views.Etape.class})
	private List<Etape> etapes;
	
	@OneToMany(mappedBy="modele")
	@JsonView(Views.ModeleWithNotes.class)
	private List<Note> notes;
	
	@Column(name="modele_img")
	private String image;
	
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
	
	@Column(name = "modele_note_moy", columnDefinition = "float(7,2) default 0") 
	@JsonView(Views.ModeleWithNotes.class) 
	private float noteMoy; 

	
	public float getNoteMoy() {
		return noteMoy;
	}

	public void setNoteMoy(float noteMoy) {
		this.noteMoy = noteMoy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getTemps() {
		return temps;
	}

	public void setTemps(int temps) {
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
