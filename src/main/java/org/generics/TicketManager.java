package org.generics;

import java.util.Arrays;

public class TicketManager {
    private Repository repository;

    public TicketManager(Repository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.addTicket(ticket);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                int size = result.length;
                Ticket[] newRes = new Ticket[size + 1];
                System.arraycopy(result, 0, newRes, 0, size);
                newRes[size] = ticket;
                result = newRes;
            }
        }
        return sortTickets(result);
    }

    private Ticket[] sortTickets(Ticket[] tickets) {
        Arrays.sort(tickets);
        return tickets;
    }

    private boolean matches(Ticket ticket, String from, String to) {
        return ticket.getIATAFrom().equals(from) && ticket.getIATATo().equals(to);
    }
}
