package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Maps {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "apple");
        map.put(2, "banana");
        map.put(3, "cherry");
        map.put(4, "tomato");
        map.put(5, "avocado");

        System.out.println(map);

        Set<Integer> keys = map.keySet();
        for (Integer key : keys) {
            System.out.println(map.get(key));
        }

        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> entry : entries) {
            System.out.println("Key : " + entry.getKey() + " | Value : " + entry.getValue());
            entry.setValue(entry.getValue().toUpperCase());
        }

        System.out.println(map);

    }


}
