package com.dss.basicproject.impl;

import java.util.Set;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.dss.basicproject.model.ItemEntity;
import com.dss.basicproject.model.ItemSizeEntity;
import com.dss.basicproject.model.StyleEntity;
import com.dss.basicproject.repository.ItemRepository;
import com.dss.basicproject.repository.ItemSizeRepository;
import com.dss.basicproject.repository.StyleRepository;
import com.dss.basicproject.service.Service;

public class ServiceImpl implements Service {

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
		styleRepository.save(styleEntity);
	}

	@Override
	public Iterable<StyleEntity> findAllStyles() {
		// TODO Auto-generated method stub
		return styleRepository.findAll();
	}

	@Override
	public StyleEntity findByStyleId(Integer styleid) {
		StyleEntity	style=styleRepository.findOne(styleid);
		Set<ItemEntity> items=style.getItems();
		return style;
	}

	@Override
	public void saveItemSize(ItemSizeEntity itemSizeEntity) {
		itemSizeRepository.save(itemSizeEntity);
	}

	@Override
	public Iterable<ItemSizeEntity> findAllItemSize() {
		return itemSizeRepository.findAll();
	}

	@Override
	public ItemSizeEntity findByItemSizeId(Integer itemSizeId) {
		return itemSizeRepository.findOne(itemSizeId);
	}

	@Override
	public void saveItem(ItemEntity itemEntity) {
itemRepository.save(itemEntity);
	}

	@Override
	public Iterable<ItemEntity> findAllItems() {
		return itemRepository.findAll();
	}

	@Override
	public ItemEntity findByItemId(Integer itemId) {
		// TODO Auto-generated method stub
		return itemRepository.findOne(itemId);
	}

	@Override
	public void deleteByStyle(Integer styleId) {
		// TODO Auto-generated method stub
		styleRepository.delete(styleId);
		
	}
}
