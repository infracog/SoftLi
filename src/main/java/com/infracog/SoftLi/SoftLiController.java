/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi;

import com.infracog.SoftLi.am.SoftwareLicenseRight;
import com.infracog.SoftLi.am.StatusMessage;
import com.infracog.SoftLi.am.SoftwareLicenseInventory;
import com.infracog.SoftLi.am.SoftwareManifestInventory;
import java.util.HashMap;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author pmaher
 */
@RestController
public class SoftLiController {

    private SoftwareLicenseInventory sli;


    
    @RequestMapping("/reserveRights")
    @ResponseBody
    public StatusMessage reserve(@RequestParam(value = "csiID", defaultValue = "0") String csiID,
            @RequestParam(value = "imageID") String imageID,
            @RequestParam(value = "vCPUs") String vCPUs,
            @RequestParam(value = "ram") String ram,
            @RequestParam(value = "instances") String instances) {
        return sli.reserveRights(csiID, imageID,
                Long.parseLong(vCPUs), Long.parseLong(ram), Integer.parseInt(instances));
    }

    @RequestMapping("/createRights")
    public StatusMessage create(@RequestParam(value = "csiID", defaultValue = "0") String csiID,
            @RequestParam(value = "ctcVersionID", defaultValue = "0") String ctcVersionID,
            @RequestParam(value = "quantity", defaultValue = "0") String quantity) {
        return sli.addRight(csiID, ctcVersionID, Long.parseLong(quantity));
    }
    
    @RequestMapping("listRights")
    public HashMap<String, SoftwareLicenseRight> list() {
        return sli.getSoftwareLicenseRights();
    }

    @PostConstruct
    public void init() {
        sli = Initializer.getSLI();
    }
}
