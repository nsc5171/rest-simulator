package com.nsc5171.myprojects.dao.repositories;

import com.nsc5171.myprojects.dao.entities.Simulation;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import com.nsc5171.myprojects.dao.entities.projections.SimulationWithoutResponse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface SimulationRepository extends CrudRepository<Simulation, SimulationId> {

    List<SimulationWithoutResponse> findBySimulationId_Simulator(String simulator);

    List<SimulationWithoutResponse> findBySimulationId_Identifier(String identifier);
}
