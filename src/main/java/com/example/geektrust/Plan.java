package com.example.geektrust;

import java.util.Date;

public class Plan {
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getValidDuration() {
        return validDuration;
    }

    public void setValidDuration(int validDuration) {
        this.validDuration = validDuration;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getPlanName() {
        return planName;
    }

    public void setPlanName(String planName) {
        this.planName = planName;
    }

    public Plan(Date endDate, int validDuration, int cost, String planName) {
        this.endDate = endDate;
        this.validDuration = validDuration;
        this.cost = cost;
        this.planName = planName;
    }

    private Date endDate;
    private int validDuration;
    private int cost;
    private String planName;


}
