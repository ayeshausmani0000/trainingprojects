package com.dss.basicproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.dss.basicproject.model.SeasonEntity;

@Repository
public interface SeasonRepository extends CrudRepository<SeasonEntity, Integer>{

}
