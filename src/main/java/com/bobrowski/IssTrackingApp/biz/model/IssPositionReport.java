package com.bobrowski.IssTrackingApp.biz.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor
@Data
@Entity
public class IssPositionReport {

    @Id
    @GeneratedValue
    private Long id;

    @Embedded
    @SerializedName(value = "iss_position")
    private IssPosition issPosition;

    @SerializedName(value = "timestamp")
    private LocalDateTime localDateTime;
    private String message;
}
