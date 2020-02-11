package fr.formation.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.formation.model.Etape;
import fr.formation.model.Modele;

public interface IDAOModele extends JpaRepository<Modele, Integer> {
	@Query("select m from Modele m inner join fetch m.categories c where c.parent.nom = :nom or c.nom = :nom")
	List<Modele> findByCategorie(@Param("nom") String nom);
	List<Modele> findByNomContaining(String nom);
	
	@Query("select m from Modele m inner join fetch m.categories")
	List<Modele> findAllFetchingCategories();
	
	Modele findByNom(String nom);
	
	List<Modele> findByActivation(boolean b);
}
