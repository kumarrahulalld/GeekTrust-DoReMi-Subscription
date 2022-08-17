package com.example.geektrust;

import java.util.Calendar;
import java.util.Date;

public class Plan {
    public Date getEndDate() {
        return endDate;
    }

    public int getValidDuration() {
        return validDuration;
    }

    public int getCost() {
        return cost;
    }

    public Plan(Date endDate, int validDuration, int cost) {
        this.endDate = endDate;
        this.validDuration = validDuration;
        this.cost = cost;
    }
    public void updateExpiryDate(Date date,int months)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        this.endDate=cal.getTime();
    }

    private  Date endDate;
    private final int validDuration;
    private final int cost;


}
