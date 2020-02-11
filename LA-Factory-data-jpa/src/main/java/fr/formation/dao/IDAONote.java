package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Note;

public interface IDAONote extends JpaRepository<Note, Integer> {
	@Query("select n from Note n where n.modele.id = :id")
	public List<Note> findByModeleId(@Param("id") int id);

}
