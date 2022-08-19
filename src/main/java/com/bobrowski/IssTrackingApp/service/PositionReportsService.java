package com.bobrowski.IssTrackingApp.service;

import com.bobrowski.IssTrackingApp.biz.model.IssPosition;
import com.bobrowski.IssTrackingApp.biz.model.IssPositionReport;
import com.bobrowski.IssTrackingApp.repositories.IssPositionReportsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionReportsService {
    private final IssPositionReportsRepository positionReportsRepository;

    public List<IssPositionReport> findAll() {
        return positionReportsRepository.findAll();
    }

    private List<IssPositionReport> findAllLimited(int limit) {
        return positionReportsRepository
                .findAll()
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<IssPositionReport> findAllReversedAndLimited(int limit) {
        List<IssPositionReport> reportsLimited = findAllLimited(limit);
        Collections.reverse(reportsLimited);
        return reportsLimited;
    }

    public <S extends IssPositionReport> S save(S entity) {
        return positionReportsRepository.save(entity);
    }

    public List<IssPosition> findPositionsFromNewestLimited(int limit) {
        return findAllReversedAndLimited(200)
                .stream()
                .map(IssPositionReport::getIssPosition)
                .collect(Collectors.toList());
    }
}
