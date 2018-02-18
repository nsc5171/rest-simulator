package com.nsc5171.myprojects.dao.repositories;

import com.nsc5171.myprojects.dao.entities.Simulation;
import com.nsc5171.myprojects.dao.entities.id.SimulationId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;

@Repository
public interface SimulationRepository extends CrudRepository<Simulation, SimulationId> {

    @Query(name = "limited_details_list_by_simulator_name")
    public List<Simulation> limitedListDetailBySimulatorName(@Param("simulator") String simulator);

    @Query(name = "limited_details_list_by_identifier")
    public Stream<Simulation> limitedListDetailByIdentifier(@Param("identifier") String identifier);
}
