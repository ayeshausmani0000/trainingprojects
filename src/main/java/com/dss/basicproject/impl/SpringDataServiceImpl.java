
package com.dss.basicproject.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import com.dss.basicproject.model.ClientEntity;
import com.dss.basicproject.model.ItemEntity;
import com.dss.basicproject.model.ItemSizeEntity;
import com.dss.basicproject.model.SeasonEntity;
import com.dss.basicproject.model.StyleEntity;
import com.dss.basicproject.repository.ItemRepository;
import com.dss.basicproject.repository.ItemSizeRepository;
import com.dss.basicproject.repository.StyleRepository;
import com.dss.basicproject.service.Service;

public class SpringDataServiceImpl implements Service {

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
		// StyleEntity style=styleRepository.findOne(styleid);
		//StyleEntity style = styleRepository.findById(styleid);
		 StyleEntity style=styleRepository.findByIdUsingJpql(styleid);
		// System.out.println("size is "+style.getItems());
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
		// System.out.println("Hello");
		// TODO Auto-generated method stub
		return itemSizeRepository.findOne(itemSizeId);
	}

	@Override
	public void saveItem(ItemEntity itemEntity) {
		// System.out.println("Item Save");
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
	public void deleteStyle(Integer styleId) {
		// TODO Auto-generated method stub
		styleRepository.delete(styleId);
	}

	@Override
	public StyleEntity findByStyleIdWithItems(Integer styleid) {
		// StyleEntity styleEntity = styleRepository.findById(styleid);
		StyleEntity styleEntity = styleRepository.findByIdUsingJpql(styleid);
		return styleEntity;
	}

	@Override
	public boolean isStyleExist(StyleEntity styleEntity, SeasonEntity seasonEntity, ClientEntity clientEntity) {
		// TODO Auto-generated method stub
		return false;
	}
}
