package com.dss.basicproject.service;

import com.dss.basicproject.model.ItemEntity;
import com.dss.basicproject.model.ItemSizeEntity;
import com.dss.basicproject.model.StyleEntity;

public interface Service {

	public void saveStyle(StyleEntity styleEntity);

	public Iterable<StyleEntity> findAllStyles();

	public StyleEntity findByStyleId(Integer id);

	public void saveItemSize(ItemSizeEntity itemSizeEntity);

	public Iterable<ItemSizeEntity> findAllItemSize();

	public ItemSizeEntity findByItemSizeId(Integer id);

	public void saveItem(ItemEntity itemEntity);

	public Iterable<ItemEntity> findAllItems();

	public ItemEntity findByItemId(Integer id);

	public void deleteStyle(Integer styleId);

	
}
