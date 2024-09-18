package com.example.ticketbookingsystem.service;

import com.example.ticketbookingsystem.model.Ticket;
import org.springframework.stereotype.Service;

@Service
public class TicketService {
    private final Ticket ticket;

    public TicketService() {
        // Inicializa con 10 entradas disponibles
        this.ticket = new Ticket(10);
    }

    public boolean reserveTicket() {
        return ticket.reserveTicket();
    }

    public int getAvailableTickets() {
        return ticket.getAvailableTickets();
    }
}
