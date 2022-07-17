package com.example.geektrust;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Runner {
    private Map<String,Service> subscribedService=new HashMap<>();
    private Date subscriptionStartDate=null;

    TopUp subscribedTopUp=null;

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
                    this.subscribedService.put(serviceName,new Service(serviceName,ServicePlanRegistry.getPlanByName(serviceName+"-"+planName)));
                    this.updateExpiryDate(subscribedService.get(serviceName).getPlan(),this.subscriptionStartDate,subscribedService.get(serviceName).getPlan().getValidDuration());
            }
        }
        else
        {
            System.out.println("ADD_SUBSCRIPTION_FAILED INVALID_DATE");
        }
    }

    public void updateExpiryDate(Plan plan,Date date,int months)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        plan.setEndDate(cal.getTime());
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
                this.subscribedTopUp = TopUpRegistry.getTopUpByName(topUpName);
                this.subscribedTopUp.setDurationInMonth(duration);
            }
        }
        else {
            System.out.println("ADD_TOPUP_FAILED DUPLICATE_TOPUP");
        }
    }

    public String convertDate(String inputDate)
    {
        Date date=null;
        DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        try {
            date = (Date) formatter.parse(inputDate);
        }
        catch (Exception exception)
        {

        }

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE,-10);
        int day=cal.get(Calendar.DATE);
        int month=cal.get(Calendar.MONTH)+1;
        int year=cal.get(Calendar.YEAR);
        String formatedDate = "";
        formatedDate+=day<10?"0"+day:day;
        formatedDate+="-";
        formatedDate+=month<10?"0"+month:month;
        formatedDate+="-";
        formatedDate+=year;
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
