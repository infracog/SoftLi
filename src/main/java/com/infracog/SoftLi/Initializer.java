/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi;

import com.infracog.SoftLi.am.LicenseRights;
import com.infracog.SoftLi.am.LicenseModel;
import com.infracog.SoftLi.am.LicenseModels;
import com.infracog.SoftLi.am.LicenseMetric;
import com.infracog.SoftLi.am.Manifests;
import com.infracog.SoftLi.am.SoftwareCategory;

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
    public static LicenseModels getLicenseModels() {
        LicenseModels l = new LicenseModels();
        l.addModel(new LicenseModel(
                "50", 
                new LicenseMetric(LicenseMetric.VCPU), 
                new SoftwareCategory(SoftwareCategory.APPLICATION)));
        l.addModel(new LicenseModel(
                "51", 
                new LicenseMetric(LicenseMetric.INSTANCE), 
                new SoftwareCategory(SoftwareCategory.INFRASTRUCTURE)));
        l.addModel(new LicenseModel(
                "52", 
                new LicenseMetric(LicenseMetric.INSTANCE), 
                new SoftwareCategory(SoftwareCategory.APPLICATION)));
        l.addModel(new LicenseModel(
                "53", 
                new LicenseMetric(LicenseMetric.INSTANCE), 
                new SoftwareCategory(SoftwareCategory.INFRASTRUCTURE)));
        l.addModel(new LicenseModel(
                "54", 
                new LicenseMetric(LicenseMetric.VCPU), 
                new SoftwareCategory(SoftwareCategory.APPLICATION)));
        return l;
    }
        
    public static Manifests getManifests() {
        Manifests manifests = new Manifests(getLicenseModels());
        manifests.addSwReleaseID("I-1", "50");
        manifests.addSwReleaseID("I-1", "51");
        manifests.addSwReleaseID("I-1", "53");
        manifests.addSwReleaseID("I-2", "51");
        manifests.addSwReleaseID("I-2", "52");
        manifests.addSwReleaseID("I-2", "53");
        manifests.addSwReleaseID("I-3", "50");
        manifests.addSwReleaseID("I-3", "51");
        manifests.addSwReleaseID("I-3", "53");
        manifests.addSwReleaseID("I-3", "54");
        return manifests;
    }
// Rights
// 1    50: 32  
// 2    50: 16      54: 16
// 3    52:  3

    public static LicenseRights getLicenseRights() {
        LicenseRights sli = new LicenseRights();
        sli.addRight("1", "50", 32);
        sli.addRight("2", "50", 16);
        sli.addRight("2", "54", 16);
        sli.addRight("3", "52", 3);
        return sli;
    }

}
