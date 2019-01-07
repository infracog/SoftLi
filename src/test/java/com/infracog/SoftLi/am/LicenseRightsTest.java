/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi.am;

import com.infracog.SoftLi.Initializer;
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

    LicenseRights licenseRights;
    

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
        licenseRights = Initializer.getLicenseRights();
    }

    @After
    public void tearDown() {
    }
    
    @Test
    public void testReserveRightsSuccess() {
        System.out.println("reserveRights: Success");
        StatusMessage result = licenseRights.reserveRights("2", "I-3", 8, 512, 1);
        assertEquals(0, result.getStatus());
    }
    
    @Test
    public void testReserveRightsFail() {
        System.out.println("reserveRights: Fail");
        StatusMessage result = licenseRights.reserveRights("2", "I-3", 24, 512, 1);
        assertEquals(1, result.getStatus());

    }
    
    @Test
    public void testGetSoftwareLicenseRights() {
        System.out.println("getSoftwareLicenseRights");
        HashMap<String, LicenseRight> expResult = null;
        HashMap<String, LicenseRight> result = licenseRights.getSoftwareLicenseRights();
        assertEquals(4, result.size());
        System.out.println("Rights:\n" + result);
    }

}
