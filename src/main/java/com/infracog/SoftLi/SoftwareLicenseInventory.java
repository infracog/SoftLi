/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi;

import java.util.HashMap;

/**
 *
 * @author pmaher
 */
public class SoftwareLicenseInventory {

    private HashMap<String, SoftwareLicenseRight> map;

    public SoftwareLicenseInventory() {
        map = new HashMap<>();
    }

    public void addRight(String csiID, String ctcVersionID, long quantity) {
        SoftwareLicenseRight slr = new SoftwareLicenseRight(csiID, ctcVersionID, quantity);
        map.put(slr.getKey(), slr);
    }

    public boolean reserveRights(String csiID, String ctcVersionID, long quantity) {
        boolean availableRights = false;
        String slrKey = csiID + "-" + ctcVersionID;
        long licenseRights = 0;
        if (map.containsKey(slrKey)) {
            licenseRights = map.get(slrKey).getQuantity();
            if (licenseRights >= quantity) {
                availableRights = true;
            }
        }
        return availableRights;
    }

}
