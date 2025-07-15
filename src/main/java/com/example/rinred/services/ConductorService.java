package com.example.rinred.services;


import com.example.rinred.models.Conductor;
import com.example.rinred.repositories.ConductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    public Conductor obtenerConductor(Long id) {
        return conductorRepository.findById(id).orElse(null);
    }
}
