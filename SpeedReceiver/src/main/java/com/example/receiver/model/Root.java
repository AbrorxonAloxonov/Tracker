package com.example.receiver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Root{
    public Double altitude;
    public byte batt;
    public String bearing;
    public Double accuracy;
    public Double lon;
    private String id;
    public Double lat;
    public Double speed;
    public Long timestamp;
}