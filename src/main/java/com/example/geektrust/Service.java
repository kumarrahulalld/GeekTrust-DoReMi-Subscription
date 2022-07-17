package com.example.geektrust;

public class Service {
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Service(String serviceName, Plan plan) {
        this.serviceName = serviceName;
        this.plan = plan;
    }

    private String serviceName;
    private Plan plan;

}
