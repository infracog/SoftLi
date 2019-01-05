/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi;

import com.infracog.SoftLi.am.SoftwareLicenseInventory;
import com.infracog.SoftLi.am.SoftwareLicenseMetricLookup;
import com.infracog.SoftLi.am.SoftwareLicenseModel;
import com.infracog.SoftLi.am.SoftwareManifestInventory;

/**
 *
 * @author pmaher
 */
public class Initializer {

//  Applications
//  1
//  2
//  3
// Software
// 50 vCPU (WAS ND)
// 51 Instance (RHEL)
// 52 Instance (Mongo)
// 53 Instance (Qualys)
// 54 vCPU (Kafka)
// Images  *App Licensed*
// I-1  51, 53, *50*
// I-2  51, 53, 52
// I-3  51, 53, *50*, *54*
    public static SoftwareManifestInventory getSMI() {
        SoftwareLicenseMetricLookup l = new SoftwareLicenseMetricLookup();
        l.addReference("50", SoftwareLicenseModel.VCPU);
        l.addReference("51", SoftwareLicenseModel.INSTANCE);
        l.addReference("52", SoftwareLicenseModel.INSTANCE);
        l.addReference("53", SoftwareLicenseModel.INSTANCE);
        l.addReference("54", SoftwareLicenseModel.VCPU);
        
        SoftwareManifestInventory manifest = new SoftwareManifestInventory(l);
        manifest.addSoftwareID("I-1", "50");
        manifest.addSoftwareID("I-1", "51");
        manifest.addSoftwareID("I-1", "53");
        manifest.addSoftwareID("I-2", "51");
        manifest.addSoftwareID("I-2", "52");
        manifest.addSoftwareID("I-2", "53");
        manifest.addSoftwareID("I-3", "50");
//        manifest.addSoftwareID("I-3", "51");
//        manifest.addSoftwareID("I-3", "53");
        manifest.addSoftwareID("I-3", "54");
        return manifest;
    }
// Rights
// 1    50: 32  
// 2    50: 16      54: 16
// 3    52:  3

    public static SoftwareLicenseInventory getSLI() {
        SoftwareLicenseInventory sli = new SoftwareLicenseInventory();
        sli.addRight("1", "50", 32);
        sli.addRight("2", "50", 16);
        sli.addRight("2", "54", 16);
        sli.addRight("3", "52", 3);
        return sli;
    }

}
