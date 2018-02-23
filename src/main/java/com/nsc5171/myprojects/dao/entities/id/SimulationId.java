package com.nsc5171.myprojects.dao.entities.id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Embeddable
@JsonIgnoreProperties(ignoreUnknown = true)
public class SimulationId implements Serializable {

    private String simulator;
    private String identifier;

}
