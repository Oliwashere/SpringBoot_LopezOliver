package com.example.jpa.controller;

import com.example.jpa.model.Mesa;
import com.example.jpa.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Mesa")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    //Obtener Mesas
    //localhost:8080/api/Mesa
    @GetMapping
    public List<Mesa> getAllMesas() {
        return mesaService.getAllMesas() ;
    }

    //localhost:8080/api/Mesa
    //Obtener mesa por ID
    @GetMapping("/{id}")
    public Mesa getMesaById(@PathVariable Long id) {
        return mesaService.getMesaById(id).orElseThrow();
    }

    //Crear mesa
    //localhost:8080/api/Mesa con verbo POST
    //{
    //  "numero_mesa":"1",
    //  "ocupada":"true"
    //  }

    @PostMapping
    public Mesa createMesa(@RequestBody Mesa mesa) {
        return mesaService.saveMesa(mesa);
    }

    //Actualizar plato
    //localhost:8080/api/Mesa/id con verbo PUT
    //{
    //  "numero_mesa":"1",
    //  "ocupada":"false"
    //  }

    @PutMapping("/{id}")
    public Mesa updateMesa(@PathVariable Long id, @RequestBody Mesa mesa) {
        return mesaService.updateMesa(id, mesa);
    }

    @DeleteMapping("/{id}")
    public void deleteMesa(@PathVariable Long id) {
        mesaService.deleteMesa(id);
    }
}
