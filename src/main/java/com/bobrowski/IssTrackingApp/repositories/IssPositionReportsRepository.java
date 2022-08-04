package com.bobrowski.IssTrackingApp.repositories;

import com.bobrowski.IssTrackingApp.biz.model.IssPositionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssPositionReportsRepository extends JpaRepository<IssPositionReport, Long> {
}
