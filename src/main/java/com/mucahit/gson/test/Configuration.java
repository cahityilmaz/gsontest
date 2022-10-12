package com.mucahit.gson.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author mucahit.yilmaz
 */
public class Configuration {

    private Map<String, Object> objectMap = new HashMap<>();

    private final String field1 = "Field 1";
    private final int field2 = 2;

    public Configuration(String configName) {
        addListToMap();

        objectMap.put("config.name", configName);
    }

    private void addListToMap() {
        List<AddressSpace> spaceList = new ArrayList<>();
        AddressSpace addressSpace1 = new AddressSpace("Test 1", 1);
        AddressSpace addressSpace2 = new AddressSpace("Test 2", 2);
        spaceList.add(addressSpace1);
        spaceList.add(addressSpace2);
        objectMap.put("space.list", spaceList);
    }

    public void putValueToMap(String key, Object value) {
        objectMap.put(key, value);
    }

}
