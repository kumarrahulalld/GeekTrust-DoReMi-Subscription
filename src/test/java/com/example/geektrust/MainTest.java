package com.example.geektrust;

import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    @Test
    public void getTopUpByNameTest()
    {
        assertEquals(100,new TopUp().getTopUpByName("TEN_DEVICE").getCostPerMonth());
    }

    @Test
    public void hasSubscriptionTest()
    {
        Runner runner=new Runner(null,null,null);
        assertFalse(runner.hasSubscription());
    }

    @Test
    public void getServiceByNameTest()
    {
        assertEquals(1,new Service().getPlanByName("MUSIC-FREE").getValidDuration());
    }

    @Test
    public void addSubscriptionTest()
    {
        Runner runner=new Runner(new HashMap<>(),new Date(),new TopUp().getTopUpByName("TEN_DEVICE"));
        runner.addSubscription("MUSIC","FREE");
        assertTrue(runner.hasSubscription());
    }

}