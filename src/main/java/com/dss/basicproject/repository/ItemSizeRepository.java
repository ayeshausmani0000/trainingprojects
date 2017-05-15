package com.dss.basicproject.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dss.basicproject.model.ItemSizeEntity;

@Repository
public interface ItemSizeRepository extends CrudRepository<ItemSizeEntity, Integer>{

}
