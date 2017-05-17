package com.dss;

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
		Service styleService = (Service) ctx.getBean("serviceImpl");
		ClientEntity client = masterService.findClientById(1);
		CountryEntity country = masterService.findCountryById(2);
		SeasonEntity season = masterService.findSeasonById(2);
		StyleEntity style = new StyleEntity();
		style.setStyleNo("Ay546");
		style.setDesc("floral shirt");
		style.setSeason(season);
		style.setCountry(country);
		style.setClient(client);
		styleService.saveStyle(style);

		ctx.close();
	}

	// @Test
	public void testSaveStyleWithItems() {

		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("springconfig.xml");
				
		Service styleService = (Service) ctx.getBean("serviceImpl");
		/* StyleEntity style = styleService.findByStyleId(14); */
		@SuppressWarnings("unused")
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
	
		styleService.saveStyle(style);

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

	//@Test
	public void testSaveItemWithItemSizes() {

		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext(
				"springconfig.xml");
		Service styleService = (Service) ctx.getBean("serviceImpl");
		
		StyleEntity style = styleService.findByStyleId(113);
		SizeEntity size=masterService.findSizeById(1);
	
		ItemEntity item=new ItemEntity();
		item.setItemNo("H123");
		item.setColor("Blue");
		item.setStyle(style);
		
		ItemSizeEntity itemSize=new ItemSizeEntity();
		itemSize.setSize(size);
		itemSize.setItem(item);
		itemSize.setQuantity(10);
		ItemSizeEntity itemSize1=new ItemSizeEntity();
		itemSize1.setSize(size);
		itemSize1.setItem(item);
		itemSize1.setQuantity(2);
		
		Set<ItemSizeEntity> itemSizeEntities=new HashSet<ItemSizeEntity>();
		itemSizeEntities.add(itemSize);
		itemSizeEntities.add(itemSize1);
		
		item.setItemSizes(itemSizeEntities);
		
		styleService.saveItem(item);
		
		ctx.close();
	}
	
	@Test
	public void testSaveStyleItemsWithItemSizes()
	{
		Service styleService = (Service) ctx.getBean("serviceImpl");
		
		ClientEntity client = masterService.findClientById(6);
		CountryEntity country = masterService.findCountryById(2);
		SeasonEntity season = masterService.findSeasonById(54);
		SizeEntity size=masterService.findSizeById(3);
		SizeEntity size1=masterService.findSizeById(4);
		
		Set<ItemEntity> itemEntites = new HashSet<ItemEntity>();
		Set<ItemSizeEntity> itemSizeEntites = new HashSet<ItemSizeEntity>();
		
		StyleEntity styleEntity= new StyleEntity();
		styleEntity.setStyleNo("RKEyeGear47");
		styleEntity.setItems(itemEntites);
		styleEntity.setClient(client);
		styleEntity.setCountry(country);
		styleEntity.setSeason(season);
		
		ItemEntity item1 = new ItemEntity();
		item1.setItemNo("RKEyeGear47-1");
		item1.setColor("Black");
		
		ItemSizeEntity itemSizeEntity1 = new ItemSizeEntity();
		itemSizeEntity1.setQuantity(40);
		itemSizeEntity1.setSize(size);
		itemSizeEntity1.setItem(item1);
		

		ItemSizeEntity itemSizeEntity2 = new ItemSizeEntity();
		itemSizeEntity2.setQuantity(40);
		itemSizeEntity2.setSize(size1);
		itemSizeEntity2.setItem(item1);
		
		
		itemSizeEntites.add(itemSizeEntity1);
		itemSizeEntites.add(itemSizeEntity2);
		
		item1.setItemSizes(itemSizeEntites);
		item1.setStyle(styleEntity);
		
		itemEntites.add(item1);
		
		styleService.saveStyle(styleEntity);
		
		ctx.close();
	}
	
//	@Test
	public void testUpdateStyleWithItem()
	{
		Service styleService = (Service) ctx.getBean("serviceImpl");
		StyleEntity styleEntity=styleService.findByStyleId(224);
		styleEntity.setDesc("Red Jeans");
		styleEntity.setStyleNo("H1505");
		
		ItemEntity itemEntity=styleService.findByItemId(223);
		itemEntity.setColor("RED");
		itemEntity.setStyle(styleEntity);
		
		ItemEntity itemEntity1=styleService.findByItemId(233);
		itemEntity1.setColor("BLACK");
		itemEntity1.setStyle(styleEntity);
		
		Set<ItemEntity> itemEntites = new HashSet<ItemEntity>();
		itemEntites.add(itemEntity);
		itemEntites.add(itemEntity1);
		
		styleEntity.setItems(itemEntites);
		styleService.saveStyle(styleEntity);
		
		ctx.close();
	}
	
//	@Test
	public void testUpdateItemWithItemSize()
	{
		Service styleService = (Service) ctx.getBean("serviceImpl");
		ItemEntity itemEntity=styleService.findByItemId(161);
		itemEntity.setColor("YELLOW");
		itemEntity.setItemNo("HM1505");
		
		ItemSizeEntity itemSizeEntity=styleService.findByItemSizeId(201);
		itemSizeEntity.setQuantity(5);
		itemSizeEntity.setItem(itemEntity);
		
		ItemSizeEntity itemSizeEntity1=styleService.findByItemSizeId(240);
		itemSizeEntity1.setQuantity(10);
		itemSizeEntity1.setItem(itemEntity);
		
		Set<ItemSizeEntity> itemSizeEntities=new HashSet<ItemSizeEntity>();
		itemSizeEntities.add(itemSizeEntity);
		itemSizeEntities.add(itemSizeEntity1);
		
		itemEntity.setItemSizes(itemSizeEntities);
		styleService.saveItem(itemEntity);
		
		ctx.close();
	}
	
	
//	@Test
	public void testUpdateStyleWithItemSize()
	{
		Service styleService = (Service) ctx.getBean("serviceImpl");
		StyleEntity styleEntity=styleService.findByStyleId(160);
		Set<ItemSizeEntity> itemSizeEntities=new HashSet<ItemSizeEntity>();
		Set<ItemEntity> itemEntities=new HashSet<ItemEntity>();
		
		styleEntity.setStyleNo("HE1505");
		styleEntity.setDesc("YELLOW SHIRT");
		styleEntity.setItems(itemEntities);
		
		ItemEntity itemEntity=styleService.findByItemId(210);
		itemEntity.setColor("YELLOW");
		itemEntity.setItemNo("HE1505");
		itemEntity.setItemSizes(itemSizeEntities);
		itemEntity.setStyle(styleEntity);
		
		ItemEntity itemEntity1=styleService.findByItemId(213);
		itemEntity1.setColor("GREEN");
		itemEntity1.setItemNo("HE1505");
		itemEntity1.setItemSizes(itemSizeEntities);
		itemEntity1.setStyle(styleEntity);
		
		ItemSizeEntity itemSizeEntity=styleService.findByItemSizeId(177);
		itemSizeEntity.setQuantity(10);
		itemSizeEntity.setItem(itemEntity1);
		
		itemSizeEntities.add(itemSizeEntity);
		
		itemEntities.add(itemEntity);
		itemEntities.add(itemEntity1);
	
		styleService.saveStyle(styleEntity);
		
		ctx.close();
	}
	
	
	//@Test
	public void testRetrieveStyle()
	{
		Service styleService = (Service) ctx.getBean("serviceImpl");
		List<StyleEntity> styleList=(List<StyleEntity>) styleService.findAllStyles();
		for (StyleEntity styleEntity : styleList) 
		{
			
				System.out.println(styleEntity.getStyleNo());
			
			
		}
	}
}
