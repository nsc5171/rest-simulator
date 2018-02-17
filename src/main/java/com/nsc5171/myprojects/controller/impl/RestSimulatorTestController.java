package com.nsc5171.myprojects.controller.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nsc5171.myprojects.dao.entities.Simulation;
import com.nsc5171.myprojects.dao.repositories.SimulatedResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class RestSimulatorTestController {

    @Autowired
    SimulatedResponseRepository responseDao;

    @RequestMapping("/")
    public String HelloWorld(){
        Simulation response= new Simulation();
        response.setId(1);
        response.setIdentifier("identif");
        response.setSimulator("zim");
        response.setResponse("das");
        try {
            System.out.println(new ObjectMapper().writeValueAsString(response));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "helloooo";
    }

    @PostMapping
    @RequestMapping("/add")
    public String addResponse(@RequestBody Simulation response){
        responseDao.save(response);
        try {
            System.out.println(new ObjectMapper().writeValueAsString(response));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "added";
    }

    @RequestMapping(value = "/get/{delay}/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Simulation getResponse(@PathVariable Long delay, @PathVariable Long id){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return responseDao.findOne(id);
    }@RequestMapping(value = {"/get/{delay}","/get"},produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<Simulation> getAllResponses(@PathVariable(required = false) Long delay){
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Simulation> simulationList =new ArrayList<>();
        Iterator<Simulation> iterator=responseDao.findAll().iterator();
        while(iterator.hasNext()){
            simulationList.add(iterator.next());
        }
        return simulationList;
    }


}
