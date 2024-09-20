package com.example.jpa.controller;

import com.example.jpa.model.Plato;
import com.example.jpa.service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Plato")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    //Obtener platos
    //localhost:8080/api/Plato
    @GetMapping
    public List<Plato> getAllPlatos() {
        return platoService.getAllPlatos();
    }

    //localhost:8080/api/Plato
    //Obtener plato por ID
    @GetMapping("/{id}")
    public Plato getPlatoById(@PathVariable Long id) {
        return platoService.getPlatoById(id).orElseThrow();
    }

    //Crear plato
    //localhost:8080/api/Plato con verbo POST
    //{
    //  "nombre":"ceviche",
    //  "precio":2500
    //  "disponibilidad":"true"
    //  }

    @PostMapping
    public Plato createPlato(@RequestBody Plato plato) {
        return platoService.savePlato(plato);
    }

    //Actualizar plato
    //localhost:8080/api/Plato/<id> con verbo PUT
    //{
    //  "nombre":"ceviche",
    //  "precio":2000
    //  "disponibilidad":"false"
    //  }

    @PutMapping("/{id}")
    public Plato updatePlato(@PathVariable Long id, @RequestBody Plato plato) {
        return platoService.updatePlato(id, plato);
    }

    @DeleteMapping("/{id}")
    public void deletePlato(@PathVariable Long id) {
        platoService.deletePlato(id);
    }
}
