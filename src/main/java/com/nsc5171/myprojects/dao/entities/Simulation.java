package com.nsc5171.myprojects.dao.entities;

import com.fasterxml.jackson.annotation.JacksonInject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import lombok.Data;
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
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Simulation{

   @EmbeddedId
   private SimulationId simulationId;

    @NotNull
    private String responseFormat;

    @NotNull
    private String response;
}

