package com.example.geektrust;

import java.util.HashMap;
import java.util.Map;

public class ServicePlanRegistry {
    private static Map<String,Plan> registry;
    static
    {
        registry=new HashMap<>();
        registry.put("MUSIC-FREE",new Plan(null,1,0,"FREE"));
        registry.put("MUSIC-PERSONAL",new Plan(null,1,100,"PERSONAL"));
        registry.put("MUSIC-PREMIUM",new Plan(null,3,250,"PREMIUM"));
        registry.put("VIDEO-FREE",new Plan(null,1,0,"FREE"));
        registry.put("VIDEO-PERSONAL",new Plan(null,1,200,"PERSONAL"));
        registry.put("VIDEO-PREMIUM",new Plan(null,3,500,"PREMIUM"));
        registry.put("PODCAST-FREE",new Plan(null,1,0,"FREE"));
        registry.put("PODCAST-PERSONAL",new Plan(null,1,100,"PERSONAL"));
        registry.put("PODCAST-PREMIUM",new Plan(null,3,300,"PREMIUM"));
    }

    public static Plan getPlanByName(String name)
    {
        return registry.get(name);
    }
}
