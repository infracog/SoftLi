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
public class SoftwareCategory {
    public static final int APPLICATION = 0;
    public static final int INFRASTRUCTURE = 1;
    
    private final int category;
    
    public SoftwareCategory(int category) {
        this.category = category;
    }
    
    public boolean isEqual(int category) {
        return this.category == category;
    }
    
    public String getCategory() {
        switch (category) {
            case SoftwareCategory.APPLICATION:
                return "Application";
            case SoftwareCategory.INFRASTRUCTURE:
                return "Infrastructure";
        }
        return "Unknown";
    }
    
}
