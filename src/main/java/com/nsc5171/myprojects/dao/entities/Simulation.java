package com.nsc5171.myprojects.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Entity(name = "RESPONSE")
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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Header> headers;
}

