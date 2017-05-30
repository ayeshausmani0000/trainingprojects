package com.dss.basicproject.dao;

import java.util.List;

import com.dss.basicproject.model.ClientEntity;
import com.dss.basicproject.model.SeasonEntity;
import com.dss.basicproject.model.StyleEntity;

public interface EmDao {
 List<StyleEntity> findByCriteria(StyleEntity styleEntity,SeasonEntity season,ClientEntity client);
}
