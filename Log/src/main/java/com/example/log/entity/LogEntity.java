package com.example.log.entity;

import com.example.log.model.Root;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String altitude;
    public String batt;
    public String bearing;
    public String accuracy;
    public String lon;
    public String ids;
    public String lat;
    public String speed;
    public String timestamp;

    public LogEntity(Root json) {
        this.altitude = json.getAltitude();
        this.batt = json.getBatt();
        this.bearing = json.getBearing();
        this.accuracy = json.getAccuracy();
        this.lon = json.getLon();
        this.ids = json.getId();
        this.lat = json.getLat();
        this.speed = json.getSpeed();
        this.timestamp = json.getTimestamp();
    }
}
