package com.nsc5171.myprojects.dao.repositories;

import com.nsc5171.myprojects.dao.entities.Simulation;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import com.nsc5171.myprojects.dao.entities.projections.SimulationWithoutResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SimulationRepository extends CrudRepository<Simulation, SimulationId> {

    List<SimulationWithoutResponse> findBy(Class<SimulationWithoutResponse> simulationWithoutResponseClass);

    List<SimulationWithoutResponse> findBySimulationId_Simulator(String simulator);

    List<SimulationWithoutResponse> findBySimulationId_Identifier(String identifier);
}
