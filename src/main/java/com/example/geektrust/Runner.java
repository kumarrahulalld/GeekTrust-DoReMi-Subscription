package com.example.geektrust;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Runner {
    public Runner(Map<String, Service> subscribedService, Date subscriptionStartDate,TopUp subscribedTopUp) {
        this.subscribedService = subscribedService;
        this.subscriptionStartDate = subscriptionStartDate;
        this.subscribedTopUp = subscribedTopUp;
    }

    private final Map<String,Service> subscribedService;
    private Date subscriptionStartDate;
    TopUp subscribedTopUp;

    public boolean hasSubscription()
    {
        return subscriptionStartDate!=null;
    }

    public void startSubscription(String startDate)
    {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            date = sdf.parse(startDate);
            if (!startDate.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        if(date!=null)
            this.subscriptionStartDate=date;
        else
            System.out.println("INVALID_DATE");
    }

    public void addSubscription(String serviceName,String planName)
    {
        if(this.hasSubscription())
        {
            if(this.subscribedService.containsKey(serviceName))
            {
                System.out.println("ADD_SUBSCRIPTION_FAILED DUPLICATE_CATEGORY");
            }
            else {
                    this.subscribedService.put(serviceName,new Service(new Service().getPlanByName(serviceName+"-"+planName)));
                subscribedService.get(serviceName).getPlan().updateExpiryDate(this.subscriptionStartDate,subscribedService.get(serviceName).getPlan().getValidDuration());
            }
        }
        else
        {
            System.out.println("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
        }
    }



    public void addTopUp(String topUpName,int duration)
    {
        if(this.subscribedTopUp==null)
        {
            if(this.subscriptionStartDate==null)
                System.out.println("ADD_TOPUP_FAILED INVALID_DATE");
            else if(this.subscribedService.size()==0)
                System.out.println("ADD_TOPUP_FAILED SUBSCRIPTIONS_NOT_FOUND");
            else {
                this.subscribedTopUp = new TopUp().getTopUpByName(topUpName);
                this.subscribedTopUp=new TopUp(this.subscribedTopUp.getTopUpName(),this.subscribedTopUp.getCostPerMonth(),duration);
            }
        }
        else {
            System.out.println("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
        }
    }

    public String convertDate(String inputDate)
    {
        Date date=null;
        String formatedDate = "";
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try {
            date = formatter.parse(inputDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DATE,-10);
            int day=cal.get(Calendar.DATE);
            int month=cal.get(Calendar.MONTH)+1;
            int year=cal.get(Calendar.YEAR);
            formatedDate+=day<10?"0"+day:day;
            formatedDate+="-";
            formatedDate+=month<10?"0"+month:month;
            formatedDate+="-";
            formatedDate+=year;
        }
        catch (Exception exception)
        {
        }
        return formatedDate;
    }

    public void printRenewalDetails()
    {

        if(this.subscribedService.size()!=0)
        {
            int totalCost=0;
            for (Map.Entry<String,Service> entry : this.subscribedService.entrySet())
            {
                totalCost+=entry.getValue().getPlan().getCost();
                System.out.println("RENEWAL_REMINDER "+entry.getKey()+" "+this.convertDate(entry.getValue().getPlan().getEndDate().toString()));
            }
            if(this.subscribedTopUp!=null)
                totalCost+=this.subscribedTopUp.getTotalCost();
            System.out.println("RENEWAL_AMOUNT "+totalCost);

        }
        else
        {
            System.out.println("SUBSCRIPTIONS_NOT_FOUND");
        }
    }






}
