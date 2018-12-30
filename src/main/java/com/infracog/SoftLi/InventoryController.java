/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi;

import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pmaher
 */
@RestController
public class InventoryController {

    private final AtomicLong counter = new AtomicLong();
    private SoftwareLicenseInventory sli;

    @RequestMapping("/reserve")
    public String reserve(@RequestParam(value = "csiID", defaultValue = "0") String csiID,
            @RequestParam(value = "ctcVersionID", defaultValue = "0") String ctcVersionID,
            @RequestParam(value = "quantity", defaultValue = "0") String quantity) {
        long countVal = counter.incrementAndGet();
        if (sli.reserveRights(csiID, ctcVersionID, Long.parseLong(quantity))) {
            return csiID + " " + ctcVersionID + ": " + "ok";
        } else {
            return csiID + " " + ctcVersionID + ": " + "not ok";
        }
    }
    
    @RequestMapping("/create")
    public String create(@RequestParam(value = "csiID", defaultValue = "0") String csiID,
            @RequestParam(value = "ctcVersionID", defaultValue = "0") String ctcVersionID,
            @RequestParam(value = "quantity", defaultValue = "0") String quantity) {
        sli = new SoftwareLicenseInventory();
        sli.addRight(csiID, ctcVersionID, Long.parseLong(quantity));
        return "Added " + csiID + "-" + ctcVersionID + ": " + quantity;
    }

    @PostConstruct
    public void init() {
        sli = new SoftwareLicenseInventory();
        sli.addRight("1", "50", 10);
        sli.addRight("1", "51", 10);
        sli.addRight("2", "50", 20);
        sli.addRight("2", "52", 20);
    }
}
