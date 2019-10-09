package com.mensa.se.milintegration.controller;

import com.mensa.se.milintegration.entity.Request;
import com.mensa.se.milintegration.services.IntegrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/mil")
public class IntegrationController {
    @Autowired
    private IntegrationService integrationService;

    @RequestMapping(value="/getExpiryDate" , consumes = MediaType.APPLICATION_XML_VALUE , produces = MediaType.APPLICATION_XML_VALUE)
    public String getExpiryDate(@RequestBody Request req){
        return integrationService.getExpiryDate(req);
    }

}
