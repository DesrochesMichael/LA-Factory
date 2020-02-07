package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Categorie;

public interface IDAOCategorie extends JpaRepository<Categorie, Integer> {

}
