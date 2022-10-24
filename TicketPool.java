/*
* Jason Boyett - jaboye2448
* CIT 4423 01
* October 23, 2022
* mac OS
*/
import java.util.ArrayList;

public class TicketPool implements SellsTickets{//this class holds all the tickets that are sold when the program is ran on the
    private int availableTicket;
    private int maxPerSale;
    private ArrayList<Integer> sales;//the index of the list is the sale number
    //the integer's stored represent the number of tickets sold in their respective sale number

    public TicketPool(int availableTicket, int maxPerSale){//object constructor
        this.availableTicket = availableTicket;
        this.maxPerSale = maxPerSale;
        this.sales = new ArrayList<>();
    }
    @Override
    public void addSale(int amountSold){//the sellsTickets interface handles making the sale
        //once the sale is made this method adds the sale and sets the state of the object
        this.sales.add(amountSold);
        this.availableTicket -= amountSold;
    }

    public int getAvailableTicket() {
        return availableTicket;
    }

    public int getMaxPerSale() {
        if((availableTicket-maxPerSale)<0){
            return availableTicket;
        }
        if(maxPerSale > availableTicket){
            return availableTicket - maxPerSale;
        }
        else{
            return maxPerSale;
        }
    }

    public ArrayList<Integer> getSales() {
        return this.sales;
    }

    public String getSaleInfoString(){
        String info = "";
        for(int i = 0; i < this.sales.size(); i++){
            if(this.sales.get(i) == 1){
                info += String.format("Transaciont number %d sold 1 ticket\n", i+1);
            }else{
                info += String.format("Transaction number %d sold %d tickets \n", i+1, this.sales.get(i));
            }
        }
        if(this.availableTicket != 0){
            info += String.format("There were %d unsold tickets.\n", this.availableTicket);
        }
        return info;
    }
}
