package com.nsc5171.myprojects.dao.entities.projections;

import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
public class SimulationWithoutResponse {

    private SimulationId simulationId;
    private String responseFormat;
}
