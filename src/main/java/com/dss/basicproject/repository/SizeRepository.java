package com.dss.basicproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dss.basicproject.model.SizeEntity;
@Repository
public interface SizeRepository extends CrudRepository<SizeEntity, Integer>{

}
