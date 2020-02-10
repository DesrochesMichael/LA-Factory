package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Etape;

public interface IDAOEtape  extends JpaRepository<Etape, Integer>{

	List<Etape> findByModeleId (int id);
}
