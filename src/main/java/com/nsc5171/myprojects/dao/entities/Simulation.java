package com.nsc5171.myprojects.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity(name = "RESPONSE")
//@NamedQueries(value = {
//        @NamedQuery(name = "limited_details_list_by_simulator_name", query = "select r.simulationId.simulator,r.simulationId.identifier,r.responseFormat from RESPONSE r where r.simulationId.simulator= :simulator"),
//        @NamedQuery(name = "limited_details_list_by_identifier", query = "select r.simulationId.simulator,r.simulationId.identifier,r.responseFormat from RESPONSE r where r.simulationId.identifier= :identifier")
//})
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Simulation {

    @EmbeddedId
    private SimulationId simulationId;

    @NotNull
    private String responseFormat;

    @NotNull
    private String response;
}

