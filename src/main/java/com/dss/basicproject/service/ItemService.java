package com.dss.basicproject.service;

import com.dss.basicproject.model.ItemEntity;

public interface ItemService {
	public void save(ItemEntity itemEntity);

	public Iterable<ItemEntity> findAllItems();

	public ItemEntity findByItemId(Integer id);
}
