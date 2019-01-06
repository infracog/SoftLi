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
public class StatusMessage {
    public static final int SUCCESS = 0;
    public static final int FAILURE = 1;

    private final int status;
    private final String message;
    private LicenseRight slr;
    
    public StatusMessage(int status, String message) {
        this.status = status;
        this.message = message;
        slr = null;
    }
    
        public StatusMessage(int status, String message, LicenseRight slr) {
        this.status = status;
        this.message = message;
        this.slr = slr;
    }
        public int getStatus() {
        return status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setSoftwareLicenseRight(LicenseRight slr) {
        this.slr = slr;
    }
    
    public LicenseRight getSoftwareLicenseRight() {
        return slr;
    }
    

}
