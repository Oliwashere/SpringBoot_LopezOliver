package com.example.ticketbookingsystem.model;

public class Ticket {
    private int availableTickets;

    public Ticket(int initialTickets) {
        this.availableTickets = initialTickets;
    }

    public boolean reserveTicket() {
        if (availableTickets > 0) {
            availableTickets--;
            return true;
        } else {
            return false;
        }
    }

    public int getAvailableTickets() {
        return availableTickets;
    }
}
