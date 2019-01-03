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

    private final HashMap<String, SoftwareLicenseRight> map;
    private static final int SUCCESS = 0;
    private static final int FAILURE = 1;

    public SoftwareLicenseInventory() {
        map = new HashMap<>();
    }

    public StatusMessage addRight(String csiID, String ctcVersionID, long quantity) {
        StatusMessage m = null;
        SoftwareLicenseRight slr = new SoftwareLicenseRight(csiID, ctcVersionID, quantity);
        map.put(slr.getKey(), slr);
        return new StatusMessage(SUCCESS, "Software License Right created.", slr);
    }


    public StatusMessage reserveRights(String csiID, String ctcVersionID, long quantity) {
        StatusMessage m;
        String status, statusMsg;
        String slrKey = csiID + "-" + ctcVersionID;
        long licenseRights = 0;
        if (map.containsKey(slrKey)) {
            SoftwareLicenseRight slr = map.get(slrKey);
            if (slr.reserveRights(quantity)) {
                m = new StatusMessage (SUCCESS, "Rights successfully assigned", slr);
            } else {
                m = new StatusMessage (FAILURE, "Requested rights (" + quantity + ") exceed available rights.", slr);
            }
        } else {
            m = new StatusMessage (FAILURE, "No rights exist for CSI ID " + csiID + "/ CTC Version ID " + ctcVersionID + ")");
        }
        return m;
    }

    public HashMap<String, SoftwareLicenseRight> getSoftwareLicenseRights() {
        return map;
    }

}
