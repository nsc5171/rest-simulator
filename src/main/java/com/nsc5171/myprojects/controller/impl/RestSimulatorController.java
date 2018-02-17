package com.nsc5171.myprojects.controller.impl;

import com.nsc5171.myprojects.controller.AppController;
import com.nsc5171.myprojects.dao.entities.Simulation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class RestSimulatorController extends AppController {

    @PostMapping
    @RequestMapping(value = {"{simulator}/{keySearchLocation}/{keyPath}/{delay}",
            "{simulator}/{keySearchLocation}/{keyPath}"})
    public String getSimulation(@PathVariable String simulator,
                                @PathVariable String keySearchLocation,
                                @PathVariable String keyPath,
                                @PathVariable(required = false) long delay,
                                HttpServletRequest request,
                                HttpServletResponse response) throws InterruptedException, IOException {

        if (delay > 0) {
            Thread.sleep(delay);
        }
        String identifier = getIdentifierFromRequest(request, keySearchLocation, keyPath);
        Simulation simulation = simulatedResponseRepository.findBySimulatorAndIdentifier(simulator, identifier);
        return simulation.getResponse();

    }

    private String getIdentifierFromRequest(HttpServletRequest request, String keySearchLocation, String keyPath) {
        return null;
    }


}
