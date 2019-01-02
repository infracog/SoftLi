/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi;

/**
 *
 * @author pmaher
 */
public class StatusMessage {
    private final int status;
    private final String message;
    
    public int getStatus() {
        return status;
    }
    
    public String getMessage() {
        return message;
    }
    
    public StatusMessage(int status, String message) {
        this.status = status;
        this.message = message;
    }
    
}
