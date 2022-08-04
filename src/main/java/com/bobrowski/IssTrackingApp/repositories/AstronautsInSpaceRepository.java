package com.bobrowski.IssTrackingApp.repositories;

import com.bobrowski.IssTrackingApp.biz.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AstronautsInSpaceRepository extends JpaRepository<Astronaut, Long> {
    List<Astronaut> findByName(String name);
}
