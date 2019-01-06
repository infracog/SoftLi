/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi.am;

import java.util.HashMap;

/**
 *
 * @author pmaher
 * 
 * Contains a list of License Models in play for 
 */
public class LicenseModels {

    private final HashMap<String, LicenseModel> modelsMap;

    public LicenseModels() {
        modelsMap = new HashMap<>();
    }
    
    public void addModel(LicenseModel l) {
        String id = l.getID();
        if (!modelsMap.containsKey(id)) {
            modelsMap.put(id, l);
        }
    }
    
    public LicenseModel getModel(String id) {
        return modelsMap.get(id);
    }

}
