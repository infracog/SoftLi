/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi.am;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author pmaher
 */
public class Manifest {

    private final String imageID;
    private final Set<String> swReleaseIDs;

    public Manifest(String imageID, String swReleaseID) {
        this.imageID = imageID;
        swReleaseIDs = new HashSet<>();
        swReleaseIDs.add(swReleaseID);
    }

    public void addSwReleaseID(String swReleaseID) {
        swReleaseIDs.add(swReleaseID);
    }
    
    public Set<String> getSwReleaseIDs() {
        return swReleaseIDs;
    }

}
