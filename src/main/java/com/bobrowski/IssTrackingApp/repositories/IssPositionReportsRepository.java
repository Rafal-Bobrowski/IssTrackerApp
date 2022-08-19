package com.bobrowski.IssTrackingApp.repositories;

import com.bobrowski.IssTrackingApp.biz.model.IssPositionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssPositionReportsRepository extends PagingAndSortingRepository<IssPositionReport, Long> {
}
