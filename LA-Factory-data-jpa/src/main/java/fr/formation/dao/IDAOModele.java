package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;

import fr.formation.model.Modele;

public interface IDAOModele extends JpaRepository<Modele, Integer> {
//	@Query("select m from Model m inner join fetch Categorie c where c = :categorie")
//	public List<Modele> findAllByCategorie(@Param("categorie") String categorie);
}
