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
	public void testSaveStyleItemsWithItemSizes() {
		Service styleService = (Service) ctx.getBean("serviceImpl");

		ClientEntity client = masterService.findClientById(1);
		CountryEntity country = masterService.findCountryById(2);
		SeasonEntity season = masterService.findSeasonById(2);
		SizeEntity size = masterService.findSizeById(1);

		Set<ItemEntity> itemEntites = new HashSet<ItemEntity>();
		Set<ItemSizeEntity> itemSizeEntites = new HashSet<ItemSizeEntity>();

		StyleEntity styleEntity = new StyleEntity();
		// styleEntity.setId(id);
		styleEntity.setStyleNo("SeqTest9");
		styleEntity.setDesc("JACKET");
		styleEntity.setItems(itemEntites);
		styleEntity.setClient(client);
		styleEntity.setCountry(country);
		styleEntity.setSeason(season);

		ItemEntity item1 = new ItemEntity();
		// item1.setItemId(100);
		item1.setItemNo("RAVI123");
		item1.setColor("Red");

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

		styleService.saveStyle(styleEntity);

		ctx.close();
	}

	// @Test
	public void testDeleteStyle() {
		Service service = (Service) ctx.getBean("serviceImpl");

	}

	// @Test
	public void testUpdateStyle() {
		Service service = (Service) ctx.getBean("serviceImpl");
		StyleEntity styleEntity = service.findByStyleId(196);
		styleEntity.setStyleNo("ay1505");
		styleEntity.setDesc("Blue Jeans");

		Set<ItemEntity> items = new HashSet<ItemEntity>();
		ItemEntity itemEntity1 = service.findByItemId(223);
		itemEntity1.setStyle(styleEntity);
		items.add(itemEntity1);
		ItemEntity itemEntity2 = service.findByItemId(233);
		itemEntity2.setStyle(styleEntity);
		items.add(itemEntity2);
		// styleEntity.setItems(items);
		service.saveStyle(styleEntity);

	}

	// @Test
	public void testUpdateStyleWithItemSize() {
		Service styleService = (Service) ctx.getBean("serviceImpl");
		StyleEntity style = styleService.findByStyleId(36);
		style.setDesc("new");
		Set<ItemEntity> itemEntities = style.getItems();

		for (ItemEntity itemEntity : itemEntities) {
			itemEntity.setColor("RED");
			Set<ItemSizeEntity> itemSizes = itemEntity.getItemSizes();
			for (ItemSizeEntity itemSizeEntity : itemSizes) {
				itemSizeEntity.setQuantity(8);
			}
		}
		styleService.saveStyle(style);
		ctx.close();
	}

	// @Test
	public void deleteStyle() {
		Service service = (Service) ctx.getBean("serviceImpl");
		service.deleteByStyle(11);
	}

	@Test
	public void retrieveItemSizeThroughStyle() {
		Service styleService = (Service) ctx.getBean("serviceImpl");
		StyleEntity style = styleService.findByStyleId(36);
		//Set<ItemEntity> itemEntities = style.getItems();
		System.out.println(style);
		/*for (ItemEntity itemEntity : itemEntities) {
			System.out.println(itemEntity.getItemId());
			itemEntity.setColor("RED");
			Set<ItemSizeEntity> itemSizes = itemEntity.getItemSizes();
			for (ItemSizeEntity itemSizeEntity : itemSizes) {
				System.out.println(itemSizeEntity.getItemsizeId());
			}
		}*/
		ctx.close();
	}

}
