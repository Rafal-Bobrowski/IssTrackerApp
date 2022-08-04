package com.bobrowski.IssTrackingApp.biz.model;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Data
public class PeopleInSpaceReport {

    @SerializedName(value = "number")
    private int numberOfPeople;

    @SerializedName(value = "people")
    private List<Astronaut> astronauts;
    private String message;
}
