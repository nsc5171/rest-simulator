package com.nsc5171.myprojects.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("simulator")
public class RestSimulatorController {

    @RequestMapping("/")
    public String HelloWorld(){
        return "helloooo";
    }

}
