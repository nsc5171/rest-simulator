package com.nsc5171.myprojects.dao.entities.projections;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import lombok.Value;
import sun.util.resources.cldr.en.TimeZoneNames_en_IN;

import java.util.Date;
import java.util.TimeZone;

@Value
public class SimulationWithoutResponse {

    private SimulationId simulationId;

    @JsonFormat(timezone = "UTC",shape = JsonFormat.Shape.STRING,pattern = "dd-MMM-yyyy HH:mm:ss")
    private Date created;

    @JsonFormat(timezone = "UTC",shape = JsonFormat.Shape.STRING,pattern = "dd-MMM-yyyy HH:mm:ss")
    private Date lastModified;

}
