package com.bobrowski.IssTrackingApp.biz.model;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Astronaut astronaut = (Astronaut) o;
        return Objects.equals(name, astronaut.name) && Objects.equals(spaceship, astronaut.spaceship);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, spaceship);
    }
}
