package com.infracog.SoftLi;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pmaher
 */
public class SoftwareLicenseRight {
    private String csiID;
    private String ctcVersionID;
    private long quantity;
    
    public SoftwareLicenseRight (String csiID, String ctcVersionID, long quantity) {
        this.csiID = csiID;
        this.ctcVersionID = ctcVersionID;
        this.quantity = quantity;
    }
    
    public String getKey() {
        return csiID + "-" + ctcVersionID;
    }
    
    public long getQuantity() {
        return quantity;
    }
    
}
