package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Etape;

public interface IDAOEtape  extends JpaRepository<Etape, Integer>{

}
