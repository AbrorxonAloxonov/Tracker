package com.example.logik.controller;

import com.example.logik.service.RootService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MyController {
    private final RootService rootService;
    @GetMapping("metres")
    public Double getMeIntegertres(@RequestParam Integer id){
        return rootService.getMetres(id);
    }
}
