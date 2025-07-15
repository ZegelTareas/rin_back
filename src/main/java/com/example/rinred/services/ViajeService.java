package com.example.rinred.services;

import com.example.rinred.models.Conductor;
import com.example.rinred.models.Viaje;
import com.example.rinred.repositories.ConductorRepository;
import com.example.rinred.repositories.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;

    @Autowired
    private ConductorRepository conductorRepository;

    public Viaje crearViaje(Viaje viaje, Long conductorId) {
        Conductor conductor = conductorRepository.findById(conductorId)
                .orElseThrow(() -> new RuntimeException("Conductor no encontrado"));
        viaje.setConductor(conductor);
        viaje.setEstado("pendiente"); // Estado inicial por defecto
        return viajeRepository.save(viaje);
    }

    public List<Viaje> obtenerPendientesPorDni(String dni) {
        return viajeRepository.findByEstadoAndDni("pendiente", dni);
    }

    public List<Viaje> obtenerFinalizadosPorDni(String dni) {
        return viajeRepository.findByEstadoAndDni("finalizado", dni);
    }

    public void cancelarViaje(Long id) {
        viajeRepository.deleteById(id);
    }
}