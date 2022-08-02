package com.bobrowski.IssTrackingApp.biz.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ReportISS{

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
