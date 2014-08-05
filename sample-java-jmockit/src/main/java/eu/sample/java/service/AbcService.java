package eu.sample.java.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.sample.java.dao.DefDao;

@Service
public class AbcService {
    @Autowired
    private DefDao defDao;

    int aaa(int a, int b){
        return a + b + defDao.getAaa();
    }
}
