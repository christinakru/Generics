package org.generics;

public class Repository {
    private Ticket[] tickets;

    public Repository() {
        tickets = new Ticket[0];
    }

    public Ticket[] findAll() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        int size = tickets.length;
        Ticket[] newProducts = new Ticket[size + 1];
        System.arraycopy(tickets, 0, newProducts, 0, size);
        newProducts[size] = ticket;
        tickets = newProducts;
    }

    public void removeTicket(int id) {
        Ticket ticket = findById(id);
        if (ticket == null) {
            throw new NotFoundException(String.format("There is no product with such ID: %d", id));
        }

        int index = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] == ticket) {
                index = i;
                break;
            }
        }
        Ticket[] newArr = new Ticket[tickets.length - 1];
        System.arraycopy(tickets, 0, newArr, 0, index);
        System.arraycopy(tickets, index + 1, newArr, index, tickets.length - index - 1);
        tickets = newArr;
    }

    private Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getID() == id) {
                return ticket;
            }
        }
        return null;
    }
}
