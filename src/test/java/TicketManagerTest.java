import org.generics.NotFoundException;
import org.generics.Repository;
import org.generics.Ticket;
import org.generics.TicketManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TicketManagerTest {
    @Test
    public void testAddTicket() {
        Ticket ticket = new Ticket(1, 100, "LED", "KUF", 1500);
        Repository repository = new Repository();
        TicketManager manager = new TicketManager(repository);
        manager.add(ticket);

        assertEquals(1, repository.findAll().length);
        assertEquals(ticket, repository.findAll()[0]);
    }

    @Test
    public void testSearchByFromAndTo() {
        Ticket ticket1 = new Ticket(1, 100, "LED", "KUF", 1500);
        Ticket ticket2 = new Ticket(2, 200, "KUF", "GOJ", 1000);
        Repository repository = new Repository();
        TicketManager manager = new TicketManager(repository);
        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] result = manager.searchBy("LED", "KUF");
        assertEquals(1, result.length);
        assertEquals(ticket1, result[0]);
    }

    @Test
    public void testSearchByNoMatch() {
        Ticket ticket1 = new Ticket(1, 100, "LED", "KUF", 1500);
        Ticket ticket2 = new Ticket(2, 200, "KUF", "GOJ", 1000);
        Repository repository = new Repository();
        TicketManager manager = new TicketManager(repository);
        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] expected = {};
        Ticket[] actual = manager.searchBy("LED", "GOJ");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchWithSort() {
        Ticket ticket1 = new Ticket(1, 110, "LED", "KUF", 1500);
        Ticket ticket2 = new Ticket(2, 100, "LED", "KUF", 1500);
        Ticket ticket3 = new Ticket(3, 200, "KUF", "GOJ", 1000);
        Repository repository = new Repository();
        TicketManager manager = new TicketManager(repository);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);

        Ticket[] result = manager.searchBy("LED", "KUF");
        assertEquals(2, result.length);
        assertEquals(ticket2, result[0]);
        assertEquals(ticket1, result[1]);
    }
}
