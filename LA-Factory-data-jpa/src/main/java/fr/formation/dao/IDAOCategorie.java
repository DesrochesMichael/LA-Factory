package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Categorie;

public interface IDAOCategorie extends JpaRepository<Categorie, Integer> {
	public List<Categorie> findByNom(String nom);
	@Query("select c from Categorie c where c.parent = :parent")
	public List<Categorie> findByParent(@Param("parent") Categorie parent);
}
