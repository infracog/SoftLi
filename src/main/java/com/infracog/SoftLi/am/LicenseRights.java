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

    // All software license rights, indexed by the key: App ID - SW Release ID
    private final HashMap<String, LicenseRight> rights;
    // The manifest contains the list of SW Release IDs associated with an Image ID
    private final Manifests manifests;
    private final LicenseModels models;

    public LicenseRights() {
        rights = new HashMap<>();
        manifests = Initializer.getManifests();  // temporary measure
        models = Initializer.getLicenseModels();
    }

    public StatusMessage addRight(String appID, String swReleaseID, long quantity) {
        LicenseRight licenseRight = new LicenseRight(appID, swReleaseID, quantity);
        rights.put(licenseRight.generateKey(), licenseRight);
        return new StatusMessage(StatusMessage.SUCCESS, "Software License Right created.", licenseRight);
    }

    public StatusMessage reserveRights(String appID, String imageID,
            long vCPU, long ram, long instances) {
        StatusMessage m = null;
        String statusMsg = null;
        String slrKey;
        long quantity;
        // From the image id, check the manifest and get all the Software Release IDs associated with the image
        Set<String> swReleaseIDs = manifests.getManifest(imageID).getSwReleaseIDs();
        if (!swReleaseIDs.isEmpty()) {
            boolean rightsAvailable = true;
            statusMsg = appID + ":";
            // First check each swReleaseID to see if the App has enough rights to set
            for (String swReleaseID : swReleaseIDs) {
                slrKey = appID + "-" + swReleaseID;
                if (rights.containsKey(slrKey)) {
                    LicenseRight slr = rights.get(slrKey);
                    switch (models.getModel(swReleaseID).getLicenseMetric().getMetricValue()) {
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
                    if (!slr.hasAvailableRights(quantity)) {
                        rightsAvailable = false;
                    }
                    statusMsg = statusMsg.concat("{  swReleaseID: " + swReleaseID
                            + "  qtyOwned: " + slr.getQuantityOwned()
                            + "  qtyInUse: " + slr.getQuantityReserved()
                            + "  category: " + models.getModel(swReleaseID).getSoftwareCategory().getCategory()
                            + "}");
                    System.out.println("Rights Available: " + rightsAvailable + " Status Message: " + statusMsg);
                } else {
                    // !licenseRights.containsKey(slrKey)
                    if (models.getModel(swReleaseID).getSoftwareCategory().isEqual(SoftwareCategory.APPLICATION)) {
                        rightsAvailable = false;
                    }
                    statusMsg = statusMsg.concat("{  swReleaseID: " + swReleaseID
                            + "  qtyOwned: 0"
                            + "  category: " + models.getModel(swReleaseID).getSoftwareCategory().getCategory()
                            + "}");
                }
            }
            // All rights have been checked at this point.
            if (rightsAvailable) {
                statusMsg = " { App ID : " + appID + " ";
                for (String swReleaseID : swReleaseIDs) {
                    slrKey = appID + "-" + swReleaseID;
                    if (rights.containsKey(slrKey)) {
                        LicenseRight slr = rights.get(slrKey);
                        switch (models.getModel(swReleaseID).getLicenseMetric().getMetricValue()) {
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
                        if (models.getModel(swReleaseID).getSoftwareCategory().isEqual(SoftwareCategory.APPLICATION)) {
                            slr.reserveRights(quantity);
                        }
                        statusMsg = statusMsg.concat("{  swReleaseID: " + swReleaseID
                                + "  qtyOwned: " + slr.getQuantityOwned()
                                + "  qtyInUse: " + slr.getQuantityReserved()
                                + "  category: " + models.getModel(swReleaseID).getSoftwareCategory().getCategory()
                                + "}");
                    }
                    System.out.println("Status Message: " + statusMsg);
                }
                m = new StatusMessage(StatusMessage.SUCCESS, "Rights successfully assigned " + statusMsg);
            } else {
                // !rightsAvailable
                m = new StatusMessage(StatusMessage.FAILURE, "Rights are not available for all titles " + statusMsg);
            }
        } else {
            m = new StatusMessage(StatusMessage.FAILURE, "No manifest found for ImageID: " + imageID);
        }
        return m;
    }

    public HashMap<String, LicenseRight> getSoftwareLicenseRights() {
        return rights;
    }

}
