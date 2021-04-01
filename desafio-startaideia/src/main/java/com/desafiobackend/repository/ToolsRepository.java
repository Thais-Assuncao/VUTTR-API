package com.desafiobackend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desafiobackend.model.Tools;

@Repository
public interface ToolsRepository extends JpaRepository<Tools, Long> {

	Optional<Tools> findById(Long id);
	
	@Query(value = "select t from Tools t join t.tags tag where tag = :tagStr")
	public List<Tools> findByTag(@Param("tagStr") String tagStr);
	
}
	