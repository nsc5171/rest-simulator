package com.nsc5171.myprojects.controller.impl;

import com.nsc5171.myprojects.controller.AppController;
import com.nsc5171.myprojects.dao.entities.Simulation;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import com.nsc5171.myprojects.dao.entities.projections.SimulationWithoutResponse;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api( description = "Manage Simulations" )
public class SimulationResponsesController extends AppController {

    @PostMapping(value = "/encodeResponse", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String encodeResponse(@RequestBody String response) {
        return encodeDecodeUtil.encode(response);
    }

    @PostMapping(value = "/decodeResponse", consumes = MediaType.TEXT_PLAIN_VALUE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String decodeResponse(@RequestBody String decodeResponse) {
        return encodeDecodeUtil.decode(decodeResponse);
    }


    @PostMapping(value = "/addOrUpdateSimulations")
    public Iterable<Simulation> addOrUpdateSimulations(@RequestBody List<Simulation> simulations) {
        return simulationRepository.save(simulations);
    }


    @DeleteMapping(value = "/deleteSimulations")
    public String deleteSimulationBySimulationIds(@RequestBody List<SimulationId> simulationIds) {
        StringBuffer message=new StringBuffer();
        for(SimulationId toBeDeleted: simulationIds) {
            if (simulationRepository.exists(toBeDeleted)) {
                simulationRepository.delete(toBeDeleted);
                message.append("Deleted simulation with simulator name: ").append(toBeDeleted.getSimulator()).append(" and identifier: ").append(toBeDeleted.getIdentifier()).append("\n");
            } else {
                message.append("Could not find simulation with simulator name: ").append(toBeDeleted.getSimulator()).append(" and identifier: ").append(toBeDeleted.getIdentifier()).append("\n");
            }
        }
        return message.toString();
    }

    @PostMapping(value = "/getSimulations")
    public Object findSimulations(@RequestBody List<SimulationId> simulationIds) {
        Iterable<Simulation> simulations = simulationRepository.findAll(simulationIds);
        if (simulations != null&&simulations.iterator().hasNext()) {
            return simulations;
        } else {
            return "Could not find simulation any matching simulations";
        }
    }

    @GetMapping(value = "/listSimulationsBySimulator/{simulator}")
    public Object listSimulationsBySimulatorName(@PathVariable String simulator) {
        List<SimulationWithoutResponse> simulations = simulationRepository.findBySimulationId_Simulator(simulator);//simulationRepository.limitedListDetailBySimulatorName(simulator);
        if (simulations != null && simulations.size() > 0) {
            return simulations;
        } else {
            return "Could not find simulation with simulator name: " + simulator;
        }
    }

    @GetMapping(value = "/listSimulationsByIdentifier/{identifier}")
    public Object listSimulationsByIdentifierName(@PathVariable String identifier) {
        List<SimulationWithoutResponse> simulations = simulationRepository.findBySimulationId_Identifier(identifier);
        if (simulations != null && simulations.size() > 0) {
            return simulations;
        } else {
            return "Could not find simulation with identifier: " + identifier;
        }
    }

    @GetMapping(value = "/listSimulations")
    public Object listAllSimulations() {
        List<SimulationWithoutResponse> simulations = simulationRepository.findBy(SimulationWithoutResponse.class);
        if (simulations != null && simulations.size() > 0) {
            return simulations;
        } else {
            return "No simulations present";
        }
    }
    @GetMapping(value = "/export")
    public Iterable<Simulation> export(){
        return simulationRepository.findAll();
    }

}
