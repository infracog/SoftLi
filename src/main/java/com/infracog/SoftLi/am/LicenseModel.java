/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi.am;

/**
 *
 * @author pmaher
 * 
 */
public class LicenseModel {
    private final String id;
    private final LicenseMetric metric;
    private final SoftwareCategory category;
    
    public LicenseModel(String id, LicenseMetric metric, SoftwareCategory category) {
        this.id = id;
        this.metric = metric;
        this.category = category;
    }
    
    public String getID() {
        return id;
    }
    
    public LicenseMetric getMetric() {
        return metric;
    }
    
    public SoftwareCategory getCategory() {
        return category;
    }
    
}
