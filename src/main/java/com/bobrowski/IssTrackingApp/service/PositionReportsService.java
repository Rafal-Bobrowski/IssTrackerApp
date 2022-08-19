package com.bobrowski.IssTrackingApp.service;

import com.bobrowski.IssTrackingApp.biz.model.IssPosition;
import com.bobrowski.IssTrackingApp.biz.model.IssPositionReport;
import com.bobrowski.IssTrackingApp.repositories.IssPositionReportsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PositionReportsService {
    private final IssPositionReportsRepository positionReportsRepository;

    public Page<IssPositionReport> findAll(Pageable pageable) {
        Pageable pageRequest = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.DESC, "id"));
        return positionReportsRepository.findAll(pageRequest);
    }

    public List<IssPositionReport> findAll() {
        List<IssPositionReport> reports = new ArrayList<>();
        positionReportsRepository.findAll().forEach(reports::add);
        return reports;
    }

    private List<IssPositionReport> findAllLimited(int limit) {
        return findAll()
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
