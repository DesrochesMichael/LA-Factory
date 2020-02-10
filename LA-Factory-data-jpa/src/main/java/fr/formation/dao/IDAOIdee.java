package fr.formation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.formation.model.Idee;

public interface IDAOIdee extends JpaRepository<Idee, Integer>  {
	
	@Query("Select i from Idee i where i.archive=?1")
	public List<Idee> findAllWhereNotArchive(Boolean archive);
	
	public List<Idee> findByArchive(Boolean archive);

}
