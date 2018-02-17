package com.nsc5171.myprojects.dao.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "RESPONSE")
@Data
public class Simulation {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RESPONSE_SEQ")
    @SequenceGenerator(sequenceName = "RESPONSE_SEQ", allocationSize = 1, name = "RESPONSE_SEQ")
    private long id;

    @NotNull
    private String simulator;

    @NotNull
    private String identifier;

    @NotNull
    private String responseFormat;

    @NotNull
    private String response;
}
