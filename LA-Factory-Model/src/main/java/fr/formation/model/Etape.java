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
	
	@Column(name = "titre", length = 25, nullable = false)
	private String titre;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "numero", length = 25, nullable = false)
	private int numero;
	
	@Column(name = "lien", nullable = true)
	private String lien;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdModele() {
		return idModele;
	}

	public void setIdModele(int idModele) {
		this.idModele = idModele;
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
