package com.infracog.SoftLi.am;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author pmaher
 */
public class LicenseRight {

    private final String appID;
    private final String swReleaseID;
    private final long qtyOwned;
    private long qtyReserved;
    
    public LicenseRight(String appID, String swReleaseID, long quantity) {
        this.appID = appID;
        this.swReleaseID = swReleaseID;
        this.qtyOwned = quantity;
        qtyReserved = 0;
    }
    
    public String generateKey() {
        return appID + "-" + swReleaseID;
    }
    
    public String getAppID() {
        return appID;
    }
    
    public String getSwReleaseID() {
        return swReleaseID;
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
    public boolean hasAvailableRights(long quantity) {
        boolean status = false;
        if (qtyReserved + quantity <= qtyOwned) {
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
