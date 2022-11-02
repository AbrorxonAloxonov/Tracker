package com.example.log.service;

import com.example.log.entity.LogEntity;
import com.example.log.model.Root;
import com.example.log.repository.LogRepository;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogService{
    private final LogRepository logRepository;
    public void save(String message){
        Gson gson = new Gson();
        Root json = gson.fromJson(message, Root.class);
        LogEntity logEntity = new LogEntity(json);
        logRepository.save(logEntity);
    }
}
