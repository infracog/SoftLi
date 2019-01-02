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
    private long qtyOwned;
    private long qtyReserved;
    
    public SoftwareLicenseRight(String csiID, String ctcVersionID, long quantity) {
        this.csiID = csiID;
        this.ctcVersionID = ctcVersionID;
        this.qtyOwned = quantity;
        qtyReserved = 0;
    }
    
    public String getKey() {
        return csiID + "-" + ctcVersionID;
    }
    
    public String getCsiID() {
        return csiID;
    }
    
    public String getCtcVersionID() {
        return ctcVersionID;
    }
    
    public long getQuantityOwned() {
        return qtyOwned;
    }
    
    public long getQuantityReserved() {
        return qtyReserved;
    }
    
    public boolean reserveRights(long quantity) {
        boolean status = false;
        if (qtyReserved + quantity <= qtyOwned) {
            qtyReserved += quantity;
            status = true;
        }
        return status;
    }
    
    public void releaseRights(long quantity) {
        if (quantity <= qtyReserved) {
            qtyReserved -= quantity;
        } else {
            qtyReserved = 0;
        }
    }
    

}
