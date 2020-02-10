package fr.formation.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Idee;

public interface IDAOIdee extends JpaRepository<Idee, Integer>  {
	
	public Optional<Idee> findByArchive(Boolean archive);

}
