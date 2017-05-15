package com.dss;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.dss.basicproject.model.ClientEntity;
import com.dss.basicproject.model.CountryEntity;
import com.dss.basicproject.model.ItemEntity;
import com.dss.basicproject.model.ItemSizeEntity;
import com.dss.basicproject.model.SeasonEntity;
import com.dss.basicproject.model.SizeEntity;
import com.dss.basicproject.model.StyleEntity;
import com.dss.basicproject.service.ItemService;
import com.dss.basicproject.service.ItemSizeService;
import com.dss.basicproject.service.MasterService;
import com.dss.basicproject.service.Service;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(locations = "classpath:springconfig.xml")
public class NewBasicProjectApplicationTests {
	ConfigurableApplicationContext ctx = null;
	MasterService masterService = null;

	@Before
	public void init() {
		ctx = new ClassPathXmlApplicationContext("springconfig.xml");
		masterService = (MasterService) ctx.getBean("masterServiceImpl");

	}

	// @Test
	public void testSaveStyle() {
		Service service = (Service) ctx.getBean("serviceImpl");
		ClientEntity client = masterService.findClientById(1);
		CountryEntity country = masterService.findCountryById(2);
		SeasonEntity season = masterService.findSeasonById(2);
		StyleEntity style = new StyleEntity();
		style.setStyleNo("Ay546");
		style.setDesc("floral shirt");
		style.setSeason(season);
		style.setCountry(country);
		style.setClient(client);
		service.saveStyle(style);

		ctx.close();
	}

	// @Test
	public void testSaveStyleWithItems() {

		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
				"springconfig.xml");
		Service service = (Service) ctx.getBean("serviceImpl");
		/* StyleEntity style = styleService.findByStyleId(14); */
		ClientEntity client = masterService.findClientById(1);
		CountryEntity country = masterService.findCountryById(2);
		SeasonEntity season = masterService.findSeasonById(2);
		StyleEntity style = new StyleEntity();
		style.setStyleNo("Ay12356");
		style.setDesc("floral shirt");
		style.setSeason(season);
		style.setCountry(country);
		ItemEntity item1 = new ItemEntity();
		item1.setItemNo("AY49687");
		item1.setColor("blue");
		item1.setStyle(style);
		ItemEntity item2 = new ItemEntity();
		item2.setItemNo("AY4967");
		item2.setColor("green");
		item2.setStyle(style);
		Set<ItemEntity> items = new HashSet<ItemEntity>();
		items.add(item1);
		items.add(item2);
		style.setItems(items);
		;

		service.saveStyle(style);

		ctx.close();
	}

	// @Test
	public void testSaveItemSize() {
		ItemSizeService itemSizeService = (ItemSizeService) ctx
				.getBean("itemSizeServiceImpl");
		SizeEntity sizeEntity = masterService.findSizeById(1);

		ItemSizeEntity itemSizeEntity = new ItemSizeEntity();
		itemSizeEntity.setQuantity(20);
		itemSizeEntity.setSize(sizeEntity);
		itemSizeService.save(itemSizeEntity);

	}

	// @Test
	public void testSaveStyleItemsWithItemSizes() {
		Service service = (Service) ctx.getBean("serviceImpl");

		ClientEntity client = masterService.findClientById(1);
		CountryEntity country = masterService.findCountryById(2);
		SeasonEntity season = masterService.findSeasonById(2);
		SizeEntity size = masterService.findSizeById(1);

		Set<ItemEntity> itemEntites = new HashSet<ItemEntity>();
		Set<ItemSizeEntity> itemSizeEntites = new HashSet<ItemSizeEntity>();

		StyleEntity styleEntity = new StyleEntity();
		styleEntity.setStyleNo("Style7689");
		styleEntity.setItems(itemEntites);
		styleEntity.setClient(client);
		styleEntity.setCountry(country);
		styleEntity.setSeason(season);

		ItemEntity item1 = new ItemEntity();
		item1.setItemNo("AY123");
		item1.setColor("blue");

		ItemSizeEntity itemSizeEntity1 = new ItemSizeEntity();
		itemSizeEntity1.setQuantity(10);
		itemSizeEntity1.setSize(size);
		itemSizeEntity1.setItem(item1);

		ItemSizeEntity itemSizeEntity2 = new ItemSizeEntity();
		itemSizeEntity2.setQuantity(20);
		itemSizeEntity2.setSize(size);
		itemSizeEntity2.setItem(item1);

		itemSizeEntites.add(itemSizeEntity1);
		itemSizeEntites.add(itemSizeEntity2);

		item1.setItemSizes(itemSizeEntites);
		item1.setStyle(styleEntity);

		itemEntites.add(item1);

		service.saveStyle(styleEntity);

	}

	//@Test
	public void testDeleteItem() {
		Service service = (Service) ctx.getBean("serviceImpl");
		ItemEntity item=service.findByItemId(210);
		
	List<ItemSizeEntity> itemSizeEntites = (List<ItemSizeEntity>) service.findAllItemSize();
	
	itemSizeEntites.remove(item);
	for (ItemSizeEntity itemSizeEntity : itemSizeEntites) {
		System.out.println(itemSizeEntity.getItem());
	}
	}
	
	@Test
	public void testDeleteStyle(){
		Service service = (Service) ctx.getBean("serviceImpl");
		StyleEntity styleEntity=service.findByStyleId(155);
		
		styleEntity.setClient(null);
		styleEntity.setCountry(null);
		styleEntity.setDesc(null);
		styleEntity.setItems(null);
		styleEntity.setSeason(null);
		styleEntity.setStyleNo(null);
		service.saveStyle(styleEntity);
		

	}
	
	//@Test
	public void testUpdateStyle(){
		Service service = (Service) ctx.getBean("serviceImpl");
		StyleEntity styleEntity=service.findByStyleId(196);
		styleEntity.setStyleNo("ay1505");
		styleEntity.setDesc("Blue Jeans");
		
		Set<ItemEntity> items=new HashSet<ItemEntity>();
		ItemEntity itemEntity1=service.findByItemId(223);
		itemEntity1.setStyle(styleEntity);
		items.add(itemEntity1);
		ItemEntity itemEntity2=service.findByItemId(233);
		itemEntity2.setStyle(styleEntity);
		items.add(itemEntity2);
		styleEntity.setItems(items);
		service.saveStyle(styleEntity);
		

	}
	
		
	
}
