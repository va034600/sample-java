package eu.sample.java.service;

import static org.junit.Assert.assertEquals;
import mockit.Deencapsulation;
import mockit.Expectations;
import mockit.Mocked;

import org.junit.Before;
import org.junit.Test;

import eu.sample.java.dao.DefDao;

//@RunWith(JMockit.class)
public class AbcServiceTest {
    private AbcService abcService = new AbcService();

    @Mocked
    private DefDao defDao;

    @Before
    public void setUp() throws Exception {
        Deencapsulation.setField(abcService, defDao);
    }

    @Test
    public void testAaa() {
        new Expectations() {
            {
                defDao.getAaa();
                result = 3;
            }
        };

        assertEquals(10, abcService.aaa(3, 4));
    }
}