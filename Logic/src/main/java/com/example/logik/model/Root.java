package com.example.logik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Root{
    public String altitude;
    public String batt;
    public String bearing;
    public String accuracy;
    public String lon;
    public Integer id;
    public String lat;
    public String speed;
    public String timestamp;
}