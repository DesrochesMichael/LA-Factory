package fr.formation.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Note;

public interface IDAONote extends JpaRepository<Note, Integer> {

}
