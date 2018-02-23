package com.nsc5171.myprojects.utils;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class SignatureUtil {

    public void addSignature(HttpServletResponse response){
        response.addHeader("ResponseType","simulated -by com.nsc5171.myprojects.rest-simulators");

    }
}
