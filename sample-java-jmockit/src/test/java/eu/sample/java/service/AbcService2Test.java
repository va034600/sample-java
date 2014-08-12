package eu.sample.java.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:context.xml" })
public class AbcService2Test {
    @Autowired
    private AbcService abcService;

    @Test
    public void testAaa() {
        assertEquals(17, abcService.aaa(3, 4));
    }
}