package com.nsc5171.myprojects.controller.impl;

import com.nsc5171.myprojects.controller.AppController;
import com.nsc5171.myprojects.dao.entities.Simulation;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import com.nsc5171.myprojects.dao.entities.projections.SimulationWithoutResponse;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@RestController
public class SimulationResponsesController extends AppController {


    @PostMapping(value = "/addOrUpdateSimulation")
    public Simulation addOrUpdateSimulation(@RequestBody Simulation simulation) {
        simulationRepository.save(simulation);
        return simulationRepository.findOne(simulation.getSimulationId());
    }



    @DeleteMapping(value = "/deleteSimulation/{simulator}/{identifier}")
    public String deleteSimulationBySimulationId(@PathVariable String simulator,@PathVariable String identifier){
        SimulationId toBeDeleted=new SimulationId(simulator,identifier);
        if(simulationRepository.exists(toBeDeleted)){
            simulationRepository.delete(toBeDeleted);
            return "Deleted simulation with simulator name: "+simulator+" and identifier: "+identifier;
        }else {
            return "Could not find simulation with simulator name: "+simulator+" and identifier: "+identifier;
        }
    }

    @GetMapping(value = "/getSimulation/{simulator}/{identifier}")
    public Object findSimulation(@PathVariable String simulator,@PathVariable String identifier){
        Simulation simulation=simulationRepository.findOne(new SimulationId(simulator,identifier));
        if(simulation!=null){
            return simulation;
        }else {
            return "Could not find simulation with simulator name: "+simulator+" and identifier: "+identifier;
        }
    }

    @GetMapping(value = "/listSimulationsBySimulator/{simulator}")
    public Object listSimulationsBySimulatorName(@PathVariable String simulator){
        List<SimulationWithoutResponse> simulations=simulationRepository.findBySimulationId_Simulator(simulator);//simulationRepository.limitedListDetailBySimulatorName(simulator);
        if(simulations!=null&&simulations.size()>0){
            return simulations;
        }else {
            return "Could not find simulation with simulator name: "+simulator;
        }
    }

    @GetMapping(value = "/listSimulationsByIdentifier/{identifier}")
    public Object listSimulationsByIdentifierName(@PathVariable String identifier){
        List<SimulationWithoutResponse> simulations=simulationRepository.findBySimulationId_Identifier(identifier);
        if(simulations!=null&&simulations.size()>0){
            return simulations;
        }else {
            return "Could not find simulation with identifier: "+identifier;
        }
    }

    @GetMapping(value = "/listSimulations")
    public Object listAllSimulations(){
        List<SimulationWithoutResponse> simulations=simulationRepository.findBy(SimulationWithoutResponse.class);
        if(simulations!=null&&simulations.size()>0){
            return simulations;
        }else {
            return "No simulations present";
        }
    }

}
