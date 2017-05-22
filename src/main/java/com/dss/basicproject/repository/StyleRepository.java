package com.dss.basicproject.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dss.basicproject.model.StyleEntity;

@Repository
public interface StyleRepository extends CrudRepository<StyleEntity, Integer> {

	@EntityGraph(value = "graph.Style.items", type = EntityGraphType.LOAD)
	StyleEntity findById(Integer id);

	@Query("SELECT s FROM StyleEntity s LEFT JOIN FETCH s.items i LEFT JOIN FETCH i.itemSizes WHERE s.id =:sid")
	StyleEntity findByIdUsingJpql(@Param("sid") Integer styleId);

	//@Query("SELECT * FROM StyleEntity")
	//StyleEntity findAll();
}
