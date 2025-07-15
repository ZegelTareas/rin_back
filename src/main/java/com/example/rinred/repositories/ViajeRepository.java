package com.example.rinred.repositories;

import com.example.rinred.models.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ViajeRepository extends JpaRepository<Viaje, Long> {
    List<Viaje> findByEstadoAndDni(String estado, String dni);
}