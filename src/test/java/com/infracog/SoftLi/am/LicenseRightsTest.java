/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi.am;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pmaher
 */
public class LicenseRightsTest {

    LicenseRights sli;
    LicenseModels models;

    public LicenseRightsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        sli = new LicenseRights();
        sli.addRight("100", "50010", 20);
        sli.addRight("200", "50010", 20);

        models = new LicenseModels();
        models.addModel(new LicenseModel(
                "50",
                new LicenseMetric(LicenseMetric.VCPU),
                new SoftwareCategory(SoftwareCategory.APPLICATION)));
        models.addModel(new LicenseModel(
                "51",
                new LicenseMetric(LicenseMetric.INSTANCE),
                new SoftwareCategory(SoftwareCategory.INFRASTRUCTURE)));

    }

    @After
    public void tearDown() {
    }
    
    @Test 
    public void testModels() {
        System.out.println("testModels");
        LicenseModel model = models.getModel("50");
        assertEquals("50", model.getID());
        assertEquals(LicenseMetric.VCPU, model.getMetric().getMetricValue());
        assertEquals(new SoftwareCategory(SoftwareCategory.APPLICATION).getCategory(), 
                model.getCategory().getCategory());
        model = models.getModel("51");
        assertEquals("51", model.getID());
        assertEquals(LicenseMetric.INSTANCE, model.getMetric().getMetricValue());
        assertEquals(new SoftwareCategory(SoftwareCategory.INFRASTRUCTURE).getCategory(), 
                model.getCategory().getCategory());
    }

    @Test
    public void testAddRight() {
        System.out.println("addRight");
        String csiID = "100";
        String ctcVersionID = "50011";
        long quantity = 20L;
        String expResult = csiID + "-" + ctcVersionID;
        StatusMessage result = sli.addRight(csiID, ctcVersionID, quantity);
        LicenseRight slr = result.getSoftwareLicenseRight();
        assertEquals(expResult, slr.generateKey());
    }

//    @Test
//    public void testReserveRightsSuccess() {
//        System.out.println("reserveRightsSuccess");
//        String csiID = "";
//        String ctcVersionID = "";
//        long quantity = 0L;
//        StatusMessage expResult = null;
//        StatusMessage result = sli.reserveRights("100", "50010", 5);
//        assertEquals(0, result.getStatus());
////        assertEquals(expResult, result);
////        fail("The test case is a prototype.");
//    }
//    @Test
//    public void testReserveRightsFail() {
//        System.out.println("reserveRightsFail");
//        String csiID = "";
//        String ctcVersionID = "";
//        long quantity = 0L;
//        StatusMessage expResult = null;
//        StatusMessage result = sli.reserveRights("100", "50011", 50);
//        assertEquals(1, result.getStatus());
////        assertEquals(expResult, result);
////        fail("The test case is a prototype.");
//    }
    @Test
    public void testGetSoftwareLicenseRights() {
        System.out.println("getSoftwareLicenseRights");
        HashMap<String, LicenseRight> expResult = null;
        HashMap<String, LicenseRight> result = sli.getSoftwareLicenseRights();
        assertEquals(2, result.size());
        System.out.println("Rights:\n" + result);
    }

}
