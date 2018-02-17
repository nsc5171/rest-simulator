package com.nsc5171.myprojects.dao.repositories;

import com.nsc5171.myprojects.dao.entities.Simulation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulatedResponseRepository extends CrudRepository<Simulation, Long> {

    public Simulation findBySimulatorAndIdentifier(String simulator, String identifier);




}
