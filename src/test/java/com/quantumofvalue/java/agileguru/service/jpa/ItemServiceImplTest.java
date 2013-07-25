package com.quantumofvalue.java.agileguru.service.jpa;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import java.util.List;
import org.junit.Test;
 
public class ItemServiceImplTest {
 
    @Test
    public void testFindAll()
        throws Exception {
        List<Item> result = itemService.findAll();
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}