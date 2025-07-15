package com.example.rinred.controllers;

import com.example.rinred.models.Viaje;
import com.example.rinred.services.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/viajes")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @PostMapping
    public Viaje crearViaje(@RequestBody Viaje viaje, @RequestParam Long conductorId) {
        return viajeService.crearViaje(viaje, conductorId);
    }

    @GetMapping("/pendientes")
    public List<Viaje> obtenerPendientes(@RequestParam String dni) {
        return viajeService.obtenerPendientesPorDni(dni);
    }

    @GetMapping("/finalizados")
    public List<Viaje> obtenerFinalizados(@RequestParam String dni) {
        return viajeService.obtenerFinalizadosPorDni(dni);
    }

    @DeleteMapping("/{id}")
    public void cancelarViaje(@PathVariable Long id) {
        viajeService.cancelarViaje(id);
    }
}