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

        assertEquals(1, repository.findAll().length);
        assertEquals(ticket, repository.findAll()[0]);
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

        assertEquals(2, repository.findAll().length);
        assertEquals(ticket1, repository.findAll()[0]);
        assertEquals(ticket2, repository.findAll()[1]);
    }

    @Test
    void removeTicket() {
        Repository repository = new Repository();
        Ticket ticket1 = new Ticket(1, 100, "LED", "KUF", 1500);
        Ticket ticket2 = new Ticket(2, 200, "KUF", "GOJ", 1000);
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);

        repository.removeProduct(1);
        assertEquals(1, repository.findAll().length);
        assertEquals(ticket2, repository.findAll()[0]);

        assertThrows(NotFoundException.class, () -> repository.removeProduct(1));
    }
}
