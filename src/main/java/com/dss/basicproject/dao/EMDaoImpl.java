package com.dss.basicproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dss.basicproject.model.ClientEntity;
import com.dss.basicproject.model.SeasonEntity;
import com.dss.basicproject.model.StyleEntity;

@Repository("emDaoImpl")
public class EMDaoImpl implements EMDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private DataSource dataSource;
	

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<StyleEntity> checkByStyleNo(StyleEntity styleEntity,
			SeasonEntity seasonEntity, ClientEntity clientEntity) 
	{
		Query query=entityManager.createQuery("SELECT s FROM StyleEntity s WHERE s.styleNo=:styleNumber AND s.season=:seasonId AND s.client=:clientId");
		query.setParameter("styleNumber", styleEntity.getStyleNo());
		query.setParameter("seasonId", seasonEntity);
		query.setParameter("clientId", clientEntity);
		List<StyleEntity> styleEntities=query.getResultList();
		return styleEntities;
	}
	

}
