package com.example.jpa.service;

import com.example.jpa.model.Plato;
import com.example.jpa.repository.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    public List<Plato> getAllPlatos() {
        return platoRepository.findAll();
    }

    public Optional<Plato> getPlatoById(Long id) {
        return platoRepository.findById(id);
    }

    public Plato savePlato(Plato plato) {
        return platoRepository.save(plato);
    }

    public void deletePlato(Long id) {
        platoRepository.deleteById(id);
    }

    public Plato updatePlato(Long id, Plato platoDetails) {
        Plato plato = platoRepository.findById(id).orElseThrow();
        plato.setName(platoDetails.getName());
        plato.setPrecio(platoDetails.getPrecio());
        plato.setDisponibilidad(platoDetails.getDisponibilidad());
        return platoRepository.save(plato);
    }
}
