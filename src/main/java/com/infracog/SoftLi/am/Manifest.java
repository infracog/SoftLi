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
    private final Set<String> ctcVersionIDs;

    public Manifest(String imageID, String ctcVersionID) {
        this.imageID = imageID;
        ctcVersionIDs = new HashSet<>();
        ctcVersionIDs.add(ctcVersionID);
    }

    public void addCtcVersionID(String ctcVersionID) {
        ctcVersionIDs.add(ctcVersionID);
    }
    
    public Set<String> getCtcVersionIDs() {
        return ctcVersionIDs;
    }

}
