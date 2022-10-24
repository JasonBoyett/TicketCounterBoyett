/*
* Jason Boyett - jaboye2448
* CIT 4423 01
* October 23, 2022
* mac OS
*/
import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args) throws Exception{
        int ticketsAvailable = 28;
        int limitPerSale = 4;
        TicketPool tickets = new TicketPool(ticketsAvailable, limitPerSale);
        tickets.sellTickets(tickets);

        JOptionPane.showMessageDialog(null,tickets.getSaleInfoString());
    }
}