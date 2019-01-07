/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi.am;

import com.infracog.SoftLi.Initializer;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pmaher
 */
public class LicenseModelsTest {

    private LicenseModels models;

    public LicenseModelsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        models = Initializer.getLicenseModels();
    }


    @Test
    public void testGetModel() {
        System.out.println("getModel");

        System.out.println("testModels");
        LicenseModel model = models.getModel("50");
        assertEquals("50", model.getID());
        assertEquals(LicenseMetric.VCPU, model.getLicenseMetric().getMetricValue());
        assertEquals(new SoftwareCategory(SoftwareCategory.APPLICATION).getCategory(),
                model.getSoftwareCategory().getCategory());

        model = models.getModel("51");
        assertEquals("51", model.getID());
        assertEquals(LicenseMetric.INSTANCE, model.getLicenseMetric().getMetricValue());
        assertEquals(new SoftwareCategory(SoftwareCategory.INFRASTRUCTURE).getCategory(),
                model.getSoftwareCategory().getCategory());
    }

}
