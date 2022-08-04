package com.bobrowski.IssTrackingApp.service;

import com.bobrowski.IssTrackingApp.biz.model.Astronaut;
import com.bobrowski.IssTrackingApp.repositories.AstronautsInSpaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PeopleInSpaceService {
    private final AstronautsInSpaceRepository astronautsRepository;

    public List<Astronaut> findByName(String name) {
        return astronautsRepository.findByName(name);
    }

    public List<Astronaut> findAll() {
        return astronautsRepository.findAll();
    }

    public <S extends Astronaut> S save(S entity) {
        return astronautsRepository.save(entity);
    }
}
