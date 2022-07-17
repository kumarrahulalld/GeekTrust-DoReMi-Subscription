package com.example.geektrust;

public class TopUp {
    public String getTopUpName() {
        return topUpName;
    }

    public void setTopUpName(String topUpName) {
        this.topUpName = topUpName;
    }

    public int getCostPerMonth() {
        return costPerMonth;
    }

    public void setCostPerMonth(int costPerMonth) {
        this.costPerMonth = costPerMonth;
    }

    public TopUp(String topUpName, int costPerMonth,int durationInMonth) {
        this.topUpName = topUpName;
        this.costPerMonth = costPerMonth;
        this.durationInMonth=durationInMonth;
    }
    public int getDurationInMonth() {
        return durationInMonth;
    }

    public void setDurationInMonth(int durationInMonth) {
        this.durationInMonth = durationInMonth;
    }

    public int getTotalCost()
    {
        return this.getCostPerMonth()*this.durationInMonth;
    }

    private String topUpName;
    private int costPerMonth;



    private int durationInMonth;


}
