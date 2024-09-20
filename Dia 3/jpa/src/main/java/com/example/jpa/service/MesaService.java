package com.example.jpa.service;

import com.example.jpa.model.Mesa;
import com.example.jpa.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    public Optional<Mesa> getMesaById(Long id) {
        return mesaRepository.findById(id);
    }

    public Mesa saveMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public void deleteMesa(Long id) {
        mesaRepository.deleteById(id);
    }

    public Mesa updateMesa(Long id, Mesa mesaDetails) {
        Mesa mesa = mesaRepository.findById(id).orElseThrow();
        mesa.setNumeroMesa(mesaDetails.getNumeroMesa());
        mesa.setOcupada(mesaDetails.getOcupada());
        return mesaRepository.save(mesa);
    }
}
