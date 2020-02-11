package fr.formation.dao;

import java.util.List;
<<<<<<< HEAD

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import fr.formation.model.Categorie;

public interface IDAOCategorie extends JpaRepository<Categorie, Integer> {
	public Categorie findByNom(String nom);

	@Query("select c from Categorie c inner join c.modeles m where m.nom = :id ")
	List<Categorie> findByModeleId(@Param ("id") int id);
}
