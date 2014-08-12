package eu.sample.java.dao;

import org.springframework.stereotype.Component;

@Component
public class DefDaoImpl implements DefDao {
    @Override
    public int getAaa() {
        return 10;
    }
}
