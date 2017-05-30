package com.dss.basicproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.dss.basicproject.model.ClientEntity;
import com.dss.basicproject.model.SeasonEntity;
import com.dss.basicproject.model.StyleEntity;

public class EmDaoImpl implements EmDao{
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<StyleEntity> findByCriteria(StyleEntity styleEntity,
			SeasonEntity season, ClientEntity client) {
		Query query =
				  entityManager.createQuery("SELECT s FROM StyleEntity s WHERE s.styleNo=:styleNumber AND s.season=:seasonId AND s.client=:clientId");
		query.setParameter("styleNumber", styleEntity.getStyleNo());
		query.setParameter("seasonId", season);
		query.setParameter("clientId", client);
				  List<StyleEntity> styleEntity1 = query.getResultList();
				 
		 return styleEntity1;
		
	}

}
