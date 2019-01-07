/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi.am;

import com.infracog.SoftLi.Initializer;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pmaher
 */
public class ManifestsTest {
    
    public Manifests manifests;
    
    public ManifestsTest() {
    }
    
    @Before
    public void setUp() {
        manifests = Initializer.getManifests();
    }


    @Test
    public void testGetSwReleaseIds() {
        System.out.println("getBinaryIds");
        Manifest manifest = manifests.getManifest("I-1");
        Set<String> binaryIDs = manifest.getSwReleaseIDs();
        assertEquals(true, binaryIDs.contains("50"));
        assertEquals(true, binaryIDs.contains("51"));
        assertEquals(true, binaryIDs.contains("53"));
        assertEquals(3, binaryIDs.size());

    }

    
}
