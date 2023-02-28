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

        Ticket[] exp = new Ticket[]{ticket};

        assertArrayEquals(exp, repository.findAll());
    }

    @Test
    public void testSearchByFromAndTo() {
        Ticket ticket1 = new Ticket(1, 100, "LED", "KUF", 1500);
        Ticket ticket2 = new Ticket(2, 200, "KUF", "GOJ", 1000);
        Repository repository = new Repository();
        TicketManager manager = new TicketManager(repository);
        manager.add(ticket1);
        manager.add(ticket2);

        Ticket[] exp = new Ticket[]{ticket1};
        Ticket[] act = manager.searchBy("LED", "KUF");

        assertArrayEquals(exp, act);
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

        Ticket[] act = manager.searchBy("LED", "KUF");
        Ticket[] exp = new Ticket[]{ticket2, ticket1};

        assertArrayEquals(exp, act);
    }
}
