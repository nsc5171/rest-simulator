package com.nsc5171.myprojects.controller;

import com.nsc5171.myprojects.dao.repositories.SimulatedResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class AppController {

    @Autowired
    protected
    SimulatedResponseRepository simulatedResponseRepository;
}
