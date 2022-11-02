package com.example.logik.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Metres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public Integer ids;
    public String timestamp;
    public String lat;
    public String lon;
    public Double distance;

    public Metres(Integer id, String lat, String lon, Double metres) {
        this.ids = id;
        this.lat = lat;
        this.lon = lon;
        this.distance = metres;
    }
}
