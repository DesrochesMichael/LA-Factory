package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Modele;

public interface IDAOModele extends JpaRepository<Modele, Integer> {

}
