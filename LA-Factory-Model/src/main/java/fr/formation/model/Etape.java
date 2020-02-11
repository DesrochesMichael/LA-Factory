package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.views.Views;

@Table
@Entity
public class Etape {

	@Id
	@Column(name = "etape_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonView(Views.Common.class)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "etape_modele", nullable = false)
	@JsonView({Views.Etape.class})
	private Modele modele;
	
	@Column(name = "etape_titre", length = 25, nullable = false)
	@JsonView({Views.Etape.class, Views.Modele.class})
	private String titre;
	
	@Column(name = "etape_description", length = 500, nullable = false)
	@JsonView({Views.Etape.class, Views.Modele.class})
	private String description;
	
	@Column(name = "etape_numero", length = 25, nullable = false)
	@JsonView({Views.Etape.class, Views.Modele.class})
	private int numero;
	
	@Column(name = "etape_lien", nullable = true)
	@JsonView({Views.Etape.class, Views.Modele.class})
	private String lien;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}
	
	
}
