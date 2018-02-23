package com.nsc5171.myprojects.utils;

import com.nsc5171.myprojects.dao.entities.Header;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component
public class ResponseUtil {

    public void addSignature(HttpServletResponse response){
        response.setHeader("ResponseType","simulated -by com.nsc5171.myprojects.rest-simulators");
    }

    public void addHeaders(HttpServletResponse response,List<Header> headers){
        if(headers!=null){
            headers.stream().forEach(header -> response.setHeader(header.getKey(),header.getValue()));
        }
    }
}
