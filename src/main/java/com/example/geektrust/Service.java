package com.example.geektrust;

public class Service {
    public Plan getPlan() {
        return plan;
    }
    public Service()
    {

    }
    public  Plan getPlanByName(String name)
    {
        switch(name)
        {
            case "MUSIC-FREE":
            case "VIDEO-FREE":
            case "PODCAST-FREE":
                return new Plan(null,1,0);
            case "MUSIC-PERSONAL":
            case "PODCAST-PERSONAL":
                return new Plan(null,1,100);
            case "MUSIC-PREMIUM":
                return new Plan(null,3,250);
            case "VIDEO-PERSONAL":
                return new Plan(null,1,200);
            case "VIDEO-PREMIUM":
                return new Plan(null,3,500);
            case "PODCAST-PREMIUM":
                return new Plan(null,3,300);
            default:
                return null;
        }
    }

    public Service(Plan plan) {
        this.plan = plan;
    }

    private  Plan plan;

}
