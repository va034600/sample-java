package eu.sample.java.service;

import static org.junit.Assert.assertEquals;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eu.sample.java.dao.DefDao;
import eu.sample.java.service.AbcService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context.xml")
public class AbcServiceTest {
    // @Tested
    AbcService abcService = new AbcService();
    @Mocked
    private DefDao defDao;

    @Before
    public void setUp() throws Exception {
        Deencapsulation.setField(abcService, defDao);
    }

    @Test
    public void testAbc() {
        new Expectations() {
            {
                defDao.getAaa();
                result = 3;
            }
        };

        assertEquals(10, abcService.aaa(3, 4));
    }
}