package com.example.ticketbookingsystem.controller;

import com.example.ticketbookingsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/reserve")
    public String reserveTicket() {
        boolean success = ticketService.reserveTicket();
        if (success) {
            return "Reserva de entrada exitosa.";
        } else {
            return "No hay entradas disponibles.";
        }
    }

    @GetMapping("/tickets")
    public String getAvailableTickets() {
        int availableTickets = ticketService.getAvailableTickets();
        return "Entradas disponibles: " + availableTickets;
    }
}
