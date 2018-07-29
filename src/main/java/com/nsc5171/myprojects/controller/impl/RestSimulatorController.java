package com.nsc5171.myprojects.controller.impl;

import com.nsc5171.myprojects.controller.AppController;
import com.nsc5171.myprojects.dao.entities.Simulation;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import com.nsc5171.myprojects.exception.IdentifierResolutionException;
import com.nsc5171.myprojects.exception.NoSuchSimulationException;
import com.nsc5171.myprojects.service.RequestParserService;
import com.nsc5171.myprojects.utils.ResponseUtil;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Log4j
@RestController
public class RestSimulatorController extends AppController {

    @Autowired
    RequestParserService requestParserService;

    @Autowired
    ResponseUtil responseUtil;


    @PostMapping(value = {"post/{simulator}/{keySearchLocation}/{keyPath}/{delay}",
            "post/{simulator}/{keySearchLocation}/{keyPath:.+}"})
    public String getPOSTSimulation(HttpServletRequest request,
                                HttpServletResponse response,
                                @PathVariable String simulator,
                                @PathVariable String keySearchLocation,
                                @PathVariable String keyPath,
                                @PathVariable(required = false) Long delay)
            throws InterruptedException, IdentifierResolutionException, NoSuchSimulationException {
        log.debug("Request for POST simulated response received");
        if (delay != null && delay > 0) {
            Thread.sleep(delay);
        }
        String identifier = requestParserService.getIdentifierFromRequest(request, keySearchLocation, keyPath);
        Simulation simulation = simulationRepository.findOne(new SimulationId(simulator, identifier));
        if (simulation == null) {
            throw new NoSuchSimulationException("Could not find a simulation mapped to simulator: " + simulator + " and identifier: " + identifier);
        }
        responseUtil.addSignature(response);
        responseUtil.addHeaders(response,simulation.getHeaders());
        return encodeDecodeUtil.decode(simulation.getResponse());

    }

    @GetMapping(value = {"get/{simulator}/{keySearchLocation}/{keyPath}/{delay}",
            "get/{simulator}/{keySearchLocation}/{keyPath:.+}"})
    public String getGETSimulation(HttpServletRequest request,
                                   HttpServletResponse response,
                                   @PathVariable String simulator,
                                   @PathVariable String keySearchLocation,
                                   @PathVariable String keyPath,
                                   @PathVariable(required = false) Long delay) throws InterruptedException, IdentifierResolutionException, NoSuchSimulationException {
        log.debug("Request for GET simulated response received");
        if (delay != null && delay > 0) {
            Thread.sleep(delay);
        }
        String identifier = requestParserService.getIdentifierFromRequest(request, keySearchLocation, keyPath);
        Simulation simulation = simulationRepository.findOne(new SimulationId(simulator, identifier));
        if (simulation == null) {
            throw new NoSuchSimulationException("Could not find a simulation mapped to simulator: " + simulator + " and identifier: " + identifier);
        }
        responseUtil.addSignature(response);
        responseUtil.addHeaders(response,simulation.getHeaders());
        return encodeDecodeUtil.decode(simulation.getResponse());

    }


}
