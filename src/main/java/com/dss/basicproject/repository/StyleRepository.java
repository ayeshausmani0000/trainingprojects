package com.dss.basicproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dss.basicproject.model.StyleEntity;
@Repository
public interface StyleRepository extends CrudRepository<StyleEntity, Integer> {

}
