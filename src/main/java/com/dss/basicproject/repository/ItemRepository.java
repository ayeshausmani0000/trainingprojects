package com.dss.basicproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dss.basicproject.model.ItemEntity;
@Repository
public interface ItemRepository extends CrudRepository<ItemEntity, Integer> {

}
