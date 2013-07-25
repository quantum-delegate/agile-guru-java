package com.quantumofvalue.java.agileguru.service.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.quantumofvalue.java.agileguru.domain.Item;
import com.quantumofvalue.java.agileguru.service.ItemService;
import com.quantumofvalue.java.agileguru.test.annotation.DataSets;

public class ItemServiceImplTest extends AbstractServiceImplTest {


	@Autowired
	ItemService itemService;
	
	@DataSets(setUpDataSet="/com/quantumofvalue/java/agileguru/service/jpa/ItemServiceImplTest.xls")
	@Test
	public void testFindAll() throws Exception {
		
		List<Item> result = itemService.findAll();
		
		assertNotNull(result);
        assertEquals(2, result.size());
	}

}
