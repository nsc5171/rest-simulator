package com.nsc5171.myprojects.controller;

import com.nsc5171.myprojects.dao.repositories.SimulationRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AppController {

    @Autowired
    protected
    SimulationRepository simulationRepository;
}
