import org.generics.NotFoundException;
import org.generics.Repository;
import org.generics.Ticket;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {
    @Test
    void addTicket() {
        Repository repository = new Repository();
        Ticket ticket = new Ticket(1, 100, "LED", "KUF", 1500);
        repository.addTicket(ticket);

        Ticket[] exp = new Ticket[]{ticket};

        assertArrayEquals(exp, repository.findAll());
        assertEquals(100, ticket.getCost());
        assertEquals(1500, ticket.getFlightTime());
    }

    @Test
    void findAll() {
        Repository repository = new Repository();
        Ticket ticket1 = new Ticket(1, 100, "LED", "KUF", 1500);
        Ticket ticket2 = new Ticket(2, 200, "KUF", "GOJ", 1000);
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);

        Ticket[] exp = new Ticket[]{ticket1, ticket2};

        assertArrayEquals(exp, repository.findAll());
    }

    @Test
    void removeTicket() {
        Repository repository = new Repository();
        Ticket ticket1 = new Ticket(1, 100, "LED", "KUF", 1500);
        Ticket ticket2 = new Ticket(2, 200, "KUF", "GOJ", 1000);
        Ticket ticket3 = new Ticket(3, 200, "KUF", "LED", 1000);
        Ticket ticket4 = new Ticket(4, 200, "GOJ", "LED", 2000);

        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        repository.addTicket(ticket4);

        repository.removeTicket(1);
        repository.removeTicket(2);
        repository.removeTicket(4);

        Ticket[] exp = new Ticket[]{ticket3};

        assertArrayEquals(exp, repository.findAll());
        assertThrows(NotFoundException.class, () -> repository.removeTicket(1));
        assertThrows(NotFoundException.class, () -> repository.removeTicket(5));
    }
}
