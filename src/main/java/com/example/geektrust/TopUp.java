package com.example.geektrust;

public class TopUp {
    public String getTopUpName() {
        return topUpName;
    }

    public int getCostPerMonth() {
        return costPerMonth;
    }

    public  TopUp getTopUpByName(String name)
    {
        switch(name)
        {
            case "FOUR_DEVICE":
                return new TopUp("FOUR",50,0);
            case "TEN_DEVICE":
                return new TopUp("TEN",100,0);
            default:
                return null;
        }
    }

    public TopUp(String topUpName, int costPerMonth,int durationInMonth) {
        this.topUpName = topUpName;
        this.costPerMonth = costPerMonth;
        this.durationInMonth=durationInMonth;
    }
    public TopUp()
    {

    }

    public int getTotalCost()
    {
        return this.getCostPerMonth()*this.durationInMonth;
    }

    private  String topUpName=null;
    private  int costPerMonth=0;



    private int durationInMonth=0;


}
