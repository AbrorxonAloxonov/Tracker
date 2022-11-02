package com.example.receiver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RootEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double speed;
    public Double lon;
    public Double lat;

    public RootEntity(String id, Double speed, Double lon, Double lat) {
        this.name = id;
        this.speed = speed;
        this.lon = lon;
        this.lat = lat;
    }
}
