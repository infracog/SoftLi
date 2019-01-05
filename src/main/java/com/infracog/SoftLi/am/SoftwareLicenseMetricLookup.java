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
 */
public class SoftwareLicenseMetricLookup {

    private final HashMap<String, String> map;

    public SoftwareLicenseMetricLookup() {
        map = new HashMap<>();
    }

    public void addReference(String ctcVersionID, String licenseMetric) {
        if (!map.containsKey(ctcVersionID)) {
            map.put(ctcVersionID, licenseMetric);
        }
    }

    public String getLicenseMetric(String ctcVersionID) {
        return map.get(ctcVersionID);
    }

}
