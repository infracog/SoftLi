/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.infracog.SoftLi;

import com.infracog.SoftLi.am.LicenseRight;
import com.infracog.SoftLi.am.StatusMessage;
import com.infracog.SoftLi.am.LicenseRights;
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

    private LicenseRights licenseRights;


    
    @RequestMapping("/reserveRights")
    @ResponseBody
    public StatusMessage reserve(@RequestParam(value = "appID", defaultValue = "0") String appID,
            @RequestParam(value = "imageID") String imageID,
            @RequestParam(value = "vCPUs") String vCPUs,
            @RequestParam(value = "ram") String ram,
            @RequestParam(value = "instances") String instances) {
        return licenseRights.reserveRights(appID, imageID,
                Long.parseLong(vCPUs), Long.parseLong(ram), Integer.parseInt(instances));
    }

    @RequestMapping("/createRights")
    public StatusMessage create(@RequestParam(value = "appID", defaultValue = "0") String appID,
            @RequestParam(value = "swReleaseID", defaultValue = "0") String swReleaseID,
            @RequestParam(value = "quantity", defaultValue = "0") String quantity) {
        return licenseRights.addRight(appID, swReleaseID, Long.parseLong(quantity));
    }
    
    @RequestMapping("listRights")
    public HashMap<String, LicenseRight> list() {
        return licenseRights.getSoftwareLicenseRights();
    }

    @PostConstruct
    public void init() {
        licenseRights = Initializer.getLicenseRights();
    }
}
