/*
* Jason Boyett - jaboye2448
* CIT 4423 01
* October 23, 2022
* mac OS
*/
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestTickets{
    @Test
    public void testTicketPoolConstructor(){
        TicketPool test = new TicketPool(28,4);

        assertEquals(28, test.getAvailableTicket());
        assertEquals(4, test.getMaxPerSale());
        assertEquals(0, test.getSales().size());
    }

    @Test
    public void testTicketPoolMethods(){

        TicketPool test = new TicketPool(28,4);
        test.addSale(4);

        assertEquals(24, test.getAvailableTicket());
        assertEquals(1, test.getSales().size());
    }
}