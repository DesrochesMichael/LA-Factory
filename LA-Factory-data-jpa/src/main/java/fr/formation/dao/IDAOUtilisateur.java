package fr.formation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Utilisateur;

public interface IDAOUtilisateur<T extends Utilisateur> extends JpaRepository<T, Integer> {

	public Optional<T> findByMailAndPassword(String mail, String password);

}
