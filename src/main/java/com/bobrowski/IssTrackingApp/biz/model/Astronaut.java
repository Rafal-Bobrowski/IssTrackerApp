package com.bobrowski.IssTrackingApp.biz.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Astronaut {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @SerializedName(value = "craft")
    private String spaceship;
}
