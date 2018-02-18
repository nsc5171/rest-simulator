package com.nsc5171.myprojects.service;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.jayway.restassured.path.xml.XmlPath;
import com.nsc5171.myprojects.exception.IdentifierResolutionException;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Log4j
@Service
public class RequestParserService {

    public String getIdentifierFromRequest(HttpServletRequest request, String keySearchLocation, String keyPath) throws IdentifierResolutionException {

        String identifier = null;
        switch (keySearchLocation.toUpperCase()) {
            case "HEADER": {
                identifier = request.getHeader(keyPath);
                log.debug("HEADER CASE: identifier :" + identifier);
                break;
            }
            case "JSON": {
                try {
                    identifier = JsonPath.parse(getRequestBodyAsString(request)).read(keyPath);
                } catch (Exception e) {
                    log.warn("Exception while querying path for value in JSON", e);
                    throw new IdentifierResolutionException("Exception while querying path for value in JSON. "+ e.getMessage(), e);
                }
                log.debug("JSON CASE: identifier :" + identifier);
                break;
            }
            case "XML": {
                try {
                    identifier = XmlPath.given(getRequestBodyAsString(request)).getString(keyPath);
                } catch (Exception e) {
                    log.warn("Exception while querying path for value in XML", e);
                    throw new IdentifierResolutionException("Exception while querying path for value in XML. "+ e.getMessage(), e);
                }
                log.debug("XML CASE: identifier :" + identifier);
                break;
            }
        }

        if (StringUtils.isBlank(identifier)) throw new IdentifierResolutionException("Could not resolve identifier");
        return identifier;
    }

    private String getRequestBodyAsString(HttpServletRequest request) throws IOException {
        String requestBody=IOUtils.toString(request.getReader());
        log.debug("Request Body: "+requestBody);
        return requestBody;
    }


}
