package com.va034600;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class SampleUtility {
    public static int plus(int value){
        return value + 6;
    }

    public static Multimap<String, String> aaa()
    {
        Multimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("key1", "value1");
        multiMap.put("key1", "value2");
        return multiMap;
    }
}
