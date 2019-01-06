/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi.am;

/**
 *
 * @author pmaher
 */
public class LicenseMetric {
    public static final int VCPU = 0;
    public static final int RAM = 1; 
    public static final int INSTANCE = 2;
    
    private final int metric;
    
    public LicenseMetric (int metric) {
        this.metric = metric;
    }
    
    public int getMetricValue() {
        return metric;
    }
    
    public String getMetric() {
        switch (metric) {
            case VCPU:
                return "vCPU";
            case RAM:
                return "RAM";
            case INSTANCE:
                return "Instance";
                
        }
        return "Unknown";
    }
    
}
