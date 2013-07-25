package com.quantumofvalue.java.agileguru.web.controller;
 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import com.quantumofvalue.java.agileguru.domain.Item;
import com.quantumofvalue.java.agileguru.service.ItemService;

import cucumber.api.java.Before;
public class ItemControllerTest extends AbstractControllerTest {
	
	private final List<Item> items = new ArrayList<Item>();
    
	private ItemService itemService;
	     
	@Before
	public void setUp() {
	    Item item = new Item("Test Item");
	    item.setId(1l);
	    items.add(item);
	}
     
    @Test
    public void testItemControllerReturnsTheCorrectView() throws Exception {
         
    	itemService = mock(ItemService.class); 
        when(itemService.findAll()).thenReturn(items);
             
        ItemController itemController = new ItemController();
        ReflectionTestUtils.setField(itemController, "itemService", itemService);
         
        ExtendedModelMap uiModel = new ExtendedModelMap();
        String result = itemController.list(uiModel);
        assertNotNull(result);
        assertEquals("items/list", result );
    } 
    @Test
    public void testItemControllerRetrievsTheItemsFromTheDatabase() throws Exception {
        itemService = mock(ItemService.class); 
        when(itemService.findAll()).thenReturn(items);
             
        ItemController itemController = new ItemController();
        ReflectionTestUtils.setField(itemController, "itemService", itemService);
        ExtendedModelMap uiModel = new ExtendedModelMap();
         
        itemController.list(uiModel);
             
        @SuppressWarnings("unchecked")
        List<Item> modelItems = (List<Item>) uiModel.get("items");
             
        Assert.assertNotNull(modelItems);
        Assert.assertArrayEquals(items.toArray(), modelItems.toArray());        
    }
}
