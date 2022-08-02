package com.bobrowski.IssTrackingApp.biz.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class IssPosition {
    private double longitude;
    private double latitude;
}
