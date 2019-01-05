/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi.am;

import com.infracog.SoftLi.am.SoftwareLicenseRight;
import com.infracog.SoftLi.am.StatusMessage;
import com.infracog.SoftLi.am.SoftwareLicenseInventory;
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
public class SoftwareLicenseInventoryTest {
    
    SoftwareLicenseInventory sli;
    
    public SoftwareLicenseInventoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sli = new SoftwareLicenseInventory();
        sli.addRight("100", "50010", 20);
        sli.addRight("200", "50010", 20);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testAddRight() {
        System.out.println("addRight");
        String csiID = "100";
        String ctcVersionID = "50011";
        long quantity = 20L;
        String expResult = csiID + "-" + ctcVersionID;
        StatusMessage result = sli.addRight(csiID, ctcVersionID, quantity);
        SoftwareLicenseRight slr = result.getSoftwareLicenseRight();
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
        HashMap<String, SoftwareLicenseRight> expResult = null;
        HashMap<String, SoftwareLicenseRight> result = sli.getSoftwareLicenseRights();
        assertEquals(2, result.size());
        System.out.println("Rights:\n" + result);
    }
    
}
