package com.bobrowski.IssTrackingApp.service;

import com.bobrowski.IssTrackingApp.biz.model.IssPositionReport;
import com.bobrowski.IssTrackingApp.repositories.IssPositionReportsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionReportsService {
    private final IssPositionReportsRepository positionReportsRepository;

    public List<IssPositionReport> findAll() {
        return positionReportsRepository.findAll();
    }

    public <S extends IssPositionReport> S save(S entity) {
        return positionReportsRepository.save(entity);
    }
}
