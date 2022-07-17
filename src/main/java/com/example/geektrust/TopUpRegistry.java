package com.example.geektrust;

import java.util.HashMap;
import java.util.Map;

public class TopUpRegistry {
    private static Map<String,TopUp> registry;
    static {
        registry=new HashMap<>();
        registry.put("FOUR_DEVICE",new TopUp("FOUR",50,0));
        registry.put("TEN_DEVICE",new TopUp("TEN",100,0));
    }

    public static TopUp getTopUpByName(String name)
    {
        return registry.get(name);
    }
}
