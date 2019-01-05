/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi.am;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author pmaher
 */
public class SoftwareManifestInventory {
    private final HashMap<String, Set<String>> map;
    SoftwareLicenseMetricLookup lookup;
    
    public SoftwareManifestInventory(SoftwareLicenseMetricLookup lookup) {
        map = new HashMap<>();
        this.lookup = lookup;
    }
    
    public void addSoftwareID(String imageID, String ctcVersionID) {
        Set<String> s;
        if (map.containsKey(imageID)) {
            s = map.get(imageID);
            s.add(ctcVersionID);
        } else {
            s = new HashSet<>();
            s.add(ctcVersionID);
            map.put(imageID, s);
        }
    }
    
    public Set<String> getSoftwareIDs(String imageID) {
        return map.get(imageID);
    }
    
    public String getSoftwareLicenseMetric(String ctcVersionID) {
        return lookup.getLicenseMetric(ctcVersionID);
    }
}
