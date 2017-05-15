package com.dss.basicproject.service;

import com.dss.basicproject.model.ItemSizeEntity;


public interface ItemSizeService {

	public void save(ItemSizeEntity itemSizeEntity);

	public Iterable<ItemSizeEntity> findAllItemSize();

	public ItemSizeEntity findByItemSizeId(Integer id);
}
