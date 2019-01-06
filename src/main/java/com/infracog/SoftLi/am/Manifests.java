/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi.am;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author pmaher
 */
public class Manifests {
    private final HashMap<String, Manifest> manifests;
    LicenseModels lookup;
    
    public Manifests(LicenseModels lookup) {
        manifests = new HashMap<>();
        this.lookup = lookup;
    }
    
    public void addSoftwareID(String imageID, String ctcVersionID) {
        if (manifests.containsKey(imageID)) {
            manifests.get(imageID).addCtcVersionID(ctcVersionID);
        } else {
            manifests.put(imageID, new Manifest(imageID, ctcVersionID));
        }
    }
    
    public Manifest getManifest(String imageID) {
        return manifests.get(imageID);
    }
    
    public Set<String> getCtcVersionIds(String imageID) {
        return manifests.get(imageID).getCtcVersionIDs();
    }
    
//    public String getSoftwareLicenseMetric(String ctcVersionID) {
//        return lookup.getLicenseMetric(ctcVersionID);
//    }
}
