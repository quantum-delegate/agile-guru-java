package com.quantumofvalue.java.agileguru.web.controller;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import com.quantumofvalue.java.agileguru.domain.Item;
import com.quantumofvalue.java.agileguru.service.ItemService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ItemControllerTest extends AbstractControllerTest {

	private ItemService itemService;
	private List<Item> items;
	ItemController itemController ;

	@Before
	public void setUp() {

		items = Arrays.asList(new Item("Item 1"), new Item("Item 2"));
	    itemController = new ItemController();
	    itemService = mock(ItemService.class);

		when(itemService.findAll()).thenReturn(items);

		
		ReflectionTestUtils
				.setField(itemController, "itemService", itemService);
	}

	@Test
	public void testItemControllerReturnsTheCorrectView() throws Exception {

		ExtendedModelMap uiModel = new ExtendedModelMap();
		String result = itemController.list(uiModel);
		assertNotNull(result);
		assertEquals("items/list", result);
	}

	@Test
	public void testItemControllerRetrievsTheItemsFromTheDatabase()
			throws Exception {
		
		ExtendedModelMap uiModel = new ExtendedModelMap();

		itemController.list(uiModel);

		@SuppressWarnings("unchecked")
		List<Item> modelItems = (List<Item>) uiModel.get("items");

		Assert.assertNotNull(modelItems);
		Assert.assertArrayEquals(items.toArray(), modelItems.toArray());
	}
}