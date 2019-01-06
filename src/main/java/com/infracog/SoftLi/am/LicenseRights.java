/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi.am;

import com.infracog.SoftLi.Initializer;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author pmaher
 */
public class LicenseRights {

    // All software license rights, indexed by the key: CSI ID - CTC Version ID
    private final HashMap<String, LicenseRight> rights;
    // The manifest contains the list of CTC Version IDs associated with an Image ID
    private final Manifests manifests;
    private final LicenseModels models;

    public LicenseRights() {
        rights = new HashMap<>();
        manifests = Initializer.getManifests();  // temporary measure
        models = Initializer.getLicenseModels();
    }

    public StatusMessage addRight(String csiID, String ctcVersionID, long quantity) {
        LicenseRight slr = new LicenseRight(csiID, ctcVersionID, quantity);
        rights.put(slr.generateKey(), slr);
        return new StatusMessage(StatusMessage.SUCCESS, "Software License Right created.", slr);
    }

    public StatusMessage reserveRights(String csiID, String imageID,
            long vCPU, long ram, long instances) {
        StatusMessage m = null;
        String statusMsg = null;
        String slrKey;
        long quantity;
        // From the image id, check the manifest and get all the CTC Version IDs associated with the image
        Set<String> ctcVersionIDs = manifests.getManifest(imageID).getCtcVersionIDs();
        if (!ctcVersionIDs.isEmpty()) {
            boolean rightsAvailable = true;
            statusMsg = csiID + ":";
            // First check each ctcVersionID to see if the CSI has enough rights to set
            for (String ctcVersionID : ctcVersionIDs) {
                slrKey = csiID + "-" + ctcVersionID;
                if (rights.containsKey(slrKey)) {
                    //
                    LicenseRight slr = rights.get(slrKey);
                    switch (models.getModel(ctcVersionID).getMetric().getMetricValue()) {
                        case LicenseMetric.INSTANCE:
                            quantity = instances;
                            break;
                        case LicenseMetric.RAM:
                            quantity = ram;
                            break;
                        case LicenseMetric.VCPU:
                            quantity = vCPU;
                            break;
                        default:
                            quantity = -1;  // TODO: Handle this case
                    }
                    if (models.getModel(ctcVersionID).getCategory().isEqual(SoftwareCategory.APPLICATION)
                            && !slr.hasAvailableRights(quantity)) {
                        rightsAvailable = false;
                    }
                    statusMsg = statusMsg.concat("{  ctcVersionID: " + ctcVersionID
                            + "  qtyOwned: " + slr.getQuantityOwned()
                            + "  qtyInUse: " + slr.getQuantityReserved()
                            + "  category: " + models.getModel(ctcVersionID).getCategory().getCategory()
                            + "}");
                } else {
                    // !licenseRights.containsKey(slrKey)
                    rightsAvailable = false;
                    statusMsg = statusMsg.concat("{  ctcVersionID: " + ctcVersionID
                            + "  qtyOwned: 0"
                            + "}");
                }
            }
            // All rights have been checked at this point.
            if (rightsAvailable) {
                statusMsg = " { CSI ID : " + csiID + " ";
                for (String ctcVersionID : ctcVersionIDs) {
                    slrKey = csiID + "-" + ctcVersionID;
                    LicenseRight slr = rights.get(slrKey);
                    switch (models.getModel(ctcVersionID).getMetric().getMetricValue()) {
                        case LicenseMetric.INSTANCE:
                            quantity = instances;
                            break;
                        case LicenseMetric.RAM:
                            quantity = ram;
                            break;
                        case LicenseMetric.VCPU:
                            quantity = vCPU;
                            break;
                        default:
                            quantity = -1;  // TODO: Handle this case
                    }
                    if (models.getModel(ctcVersionID).getCategory().isEqual(SoftwareCategory.APPLICATION))  {
                        slr.reserveRights(quantity);
                    }
                    statusMsg = statusMsg.concat("{  ctcVersionID: " + ctcVersionID
                            + "  qtyOwned: " + slr.getQuantityOwned()
                            + "  qtyInUse: " + slr.getQuantityReserved()
                            + "  category: " + models.getModel(ctcVersionID).getCategory().getCategory()
                            + "}");
                }
                m = new StatusMessage(StatusMessage.SUCCESS, "Rights successfully assigned " + statusMsg);
            } else {
                // !rightsAvailable
                m = new StatusMessage(StatusMessage.FAILURE, "Rights are not available for all titles " + statusMsg);
            }
        } else {
            // ctcVersionIDs.isEmpty()
            m = new StatusMessage(StatusMessage.FAILURE, "No manifest found for ImageID: " + imageID);
        }
        return m;
    }

    public HashMap<String, LicenseRight> getSoftwareLicenseRights() {
        return rights;
    }

}
