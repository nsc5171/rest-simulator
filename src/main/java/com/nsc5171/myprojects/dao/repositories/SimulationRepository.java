package com.nsc5171.myprojects.dao.repositories;

import com.nsc5171.myprojects.dao.entities.Simulation;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface SimulationRepository extends CrudRepository<Simulation, SimulationId> {



}
