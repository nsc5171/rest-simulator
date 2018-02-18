package com.nsc5171.myprojects.controller.impl;

import com.nsc5171.myprojects.controller.AppController;
import com.nsc5171.myprojects.dao.entities.Simulation;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import org.springframework.web.bind.annotation.*;

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

}
