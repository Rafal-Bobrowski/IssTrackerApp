package com.bobrowski.IssTrackingApp.repositories;

import com.bobrowski.IssTrackingApp.biz.model.ReportISS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsRepository extends JpaRepository<ReportISS, Long> {
}
