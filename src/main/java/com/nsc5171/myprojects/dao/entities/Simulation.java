package com.nsc5171.myprojects.dao.entities;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.annotation.Scope;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TimeZone;

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

