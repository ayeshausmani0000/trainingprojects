package com.dss.basicproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dss.basicproject.model.CountryEntity;

@Repository
public interface CountryRepository extends CrudRepository<CountryEntity	, Integer>{

}
