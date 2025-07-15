package com.example.rinred.controllers;

import com.example.rinred.models.Conductor;
import com.example.rinred.services.ConductorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/conductores")
public class ConductorController {

    @Autowired
    private ConductorService conductorService;

    @GetMapping("/{id}")
    public Conductor obtenerConductor(@PathVariable Long id) {
        return conductorService.obtenerConductor(id);
    }
}