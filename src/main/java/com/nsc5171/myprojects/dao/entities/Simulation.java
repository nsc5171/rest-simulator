package com.nsc5171.myprojects.dao.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity(name = "RESPONSE")
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Simulation {

    @EmbeddedId
    private SimulationId simulationId;

    @NotNull
    private String response;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Header> headers;

    @Column(updatable = false)
    @JsonFormat(timezone = "UTC",shape = JsonFormat.Shape.STRING,pattern = "dd-MMM-yyyy HH:mm:ss")
    @CreationTimestamp
    private Date created;

    @JsonFormat(timezone = "UTC",shape = JsonFormat.Shape.STRING,pattern = "dd-MMM-yyyy HH:mm:ss")
    @UpdateTimestamp
    private Date lastModified;
}

