package com.nsc5171.myprojects.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Header {

    @JsonIgnore
    @Id
    @SequenceGenerator(sequenceName = "header_seq", initialValue = 1, name = "header_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "header_seq")
    private Long headerId;

    @NotNull
    private String key;

    @NotNull
    private String value;

}
