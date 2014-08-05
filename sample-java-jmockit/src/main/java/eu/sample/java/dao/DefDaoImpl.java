package eu.sample.java.dao;

import org.springframework.stereotype.Service;

@Service
public class DefDaoImpl implements DefDao{
    @Override
    public int getAaa(){
        return 5;
    }
}
