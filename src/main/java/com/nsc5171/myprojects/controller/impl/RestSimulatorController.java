package com.nsc5171.myprojects.controller.impl;

import com.jayway.jsonpath.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import com.nsc5171.myprojects.controller.AppController;
import com.nsc5171.myprojects.dao.entities.Simulation;
import com.nsc5171.myprojects.exception.IdentifierResolutionException;
import com.nsc5171.myprojects.service.RequestParserService;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j
@RestController
public class RestSimulatorController extends AppController {

    @Autowired
    RequestParserService requestParserService;

    @PostMapping
    @RequestMapping(value = {"{simulator}/{keySearchLocation}/{keyPath}/{delay}",
            "{simulator}/{keySearchLocation}/{keyPath}"})
    public String getSimulation(@PathVariable String simulator,
                                @PathVariable String keySearchLocation,
                                @PathVariable String keyPath,
                                @PathVariable(required = false) long delay,
                                HttpServletRequest request,
                                HttpServletResponse response,
                                @RequestBody String requestBody) throws InterruptedException, IdentifierResolutionException {

        if (delay > 0) {
            Thread.sleep(delay);
        }
        String identifier = requestParserService.getIdentifierFromRequest(request, keySearchLocation, keyPath);
        Simulation simulation = simulatedResponseRepository.findBySimulatorAndIdentifier(simulator, identifier);
        return simulation.getResponse();

    }



}
