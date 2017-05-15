package com.dss.basicproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dss.basicproject.model.ClientEntity;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity, Integer> {

}
