package com.dss.basicproject.dao;

import java.util.List;

import com.dss.basicproject.model.ClientEntity;
import com.dss.basicproject.model.SeasonEntity;
import com.dss.basicproject.model.StyleEntity;

public interface EMDao {
	
	List<StyleEntity> checkByStyleNo(StyleEntity styleEntity, SeasonEntity seasonEntity, ClientEntity clientEntity);

}
