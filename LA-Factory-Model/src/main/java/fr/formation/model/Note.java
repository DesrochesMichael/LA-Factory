package fr.formation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonView;

import fr.formation.views.Views;

@Entity
@Table
public class Note {
	@Id
	@Column(name = "note_id")
	@JsonView(Views.Common.class)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "note_nom", length = 25, nullable = false)
	@JsonView(Views.Note.class)
	private String nom;
	
	@Column(name = "note_prenom", length = 25, nullable = false)
	@JsonView(Views.Note.class)
	private String prenom;
	
	@Column(name = "note_mail", nullable = false)
	@JsonView(Views.Note.class)
	private String mail;
	
	@Column(name = "note_commentaire", length = 500)
	@JsonView(Views.Note.class)
	private String commentaire;
	
	@Column(name = "note_valeur", nullable = false)
	@Min(0)
	@Max(5)
	@JsonView(Views.Note.class)
	private int valeur;
	
	@ManyToOne
	@JoinColumn(name = "note_modele")
	@JsonView(Views.Note.class)
	private Modele modele;

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

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}
	

}
