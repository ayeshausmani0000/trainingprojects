
package com.dss.basicproject.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dss.basicproject.model.ItemEntity;
import com.dss.basicproject.model.ItemSizeEntity;
import com.dss.basicproject.model.StyleEntity;
import com.dss.basicproject.repository.ItemRepository;
import com.dss.basicproject.repository.ItemSizeRepository;
import com.dss.basicproject.repository.StyleRepository;
import com.dss.basicproject.service.Service;

public class EntityManagerServiceImpl implements Service {

	@PersistenceContext
	private EntityManager entityManager; 
	@Autowired
	private StyleRepository styleRepository;

	@Autowired
	private ItemSizeRepository itemSizeRepository;

	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void saveStyle(StyleEntity styleEntity) {
		if (styleEntity.getId() == null) {
			entityManager.persist(styleEntity);
		} else {
			entityManager.merge(styleEntity);
		}
	}

	@Override
	public Iterable<StyleEntity> findAllStyles() {
		Query query = entityManager.createQuery("select s from StyleEntity s");
		Iterable<StyleEntity> styleEntity = query.getResultList();
		return styleEntity;
	}

	@Override
	@Transactional
	public StyleEntity findByStyleId(Integer styleid) {
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT s FROM StyleEntity s ");
		sb.append(" LEFT JOIN FETCH s.items i ");
		sb.append(" LEFT JOIN FETCH i.itemSizes  ");
		sb.append("  WHERE s.id =:sid ");
		Query query = entityManager.createQuery(sb.toString());
		query.setParameter("sid", styleid);
		return (StyleEntity) query.getSingleResult();
		
	}

	@Override
	public void saveItemSize(ItemSizeEntity itemSizeEntity) {
		if (itemSizeEntity.getItemsizeId() == null) {
			entityManager.persist(itemSizeEntity);
		} else {
			entityManager.merge(itemSizeEntity);
		}
	}

	@Override
	public Iterable<ItemSizeEntity> findAllItemSize() {
		Query query = entityManager.createQuery("select is from ItemSizeEntity is");
		Iterable<ItemSizeEntity> itemSizeEntity = query.getResultList();
		return itemSizeEntity;
	}

	@Override
	public ItemSizeEntity findByItemSizeId(Integer itemSizeId) {
		return entityManager.find(ItemSizeEntity.class,itemSizeId);
	}

	@Override
	public void saveItem(ItemEntity itemEntity) {
		if (itemEntity.getItemId() == null) {
			entityManager.persist(itemEntity);
		} else {
			entityManager.merge(itemEntity);
		}	}

	@Override
	public Iterable<ItemEntity> findAllItems() {
		Query query = entityManager.createQuery("select i from ItemEntity i");
		Iterable<ItemEntity> itemEntity = query.getResultList();
		return itemEntity;	}

	@Override
	public ItemEntity findByItemId(Integer itemId) {
		// TODO Auto-generated method stub
		return entityManager.find(ItemEntity.class,itemId);
	}

	@Override
	public void deleteStyle(Integer styleId) {
		// TODO Auto-generated method stub
		entityManager.remove(styleId);
	}
}
