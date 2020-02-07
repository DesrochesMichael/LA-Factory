package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Idee;

public interface IDAOIdee extends JpaRepository<Idee, Integer>  {

}
