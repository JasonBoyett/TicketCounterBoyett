import java.util.ArrayList;
import java.util.logging.ErrorManager;

import javax.swing.JOptionPane;

public class Main{
    public static void main(String[] args) throws Exception{
        int ticketsAvailable = 28;
        int limitPerSale = 4;

        ArrayList<Integer> sales = sellTickets(ticketsAvailable, limitPerSale);
        System.out.println(getSaleInfo(sales));

    }

    public static ArrayList<Integer> sellTickets(int available, int limitPerSale){
        try{
            ArrayList<Integer> sales = new ArrayList<Integer>(0);
            int i = 0;
            while(available > 0){
                int addThis = makeSale(available, limitPerSale);
                if(addThis == -1){

                    return sales;
                }
                else{
                    sales.add(i,addThis);
                    available -= addThis;
                }
            }
            return sales;
        }
        catch(Exception e){
            return sellTickets(available, limitPerSale);
        }
    }

    public static String getSaleInfo(ArrayList<Integer> saleList){
        String info = "";
        for(int i = 0; i < saleList.size(); i++){
            info += String.format("Transaction number %d sold %d tickets \n", i+1, saleList.get(i));
        }
        return info;
    }

    public static int makeSale(int ticketsAvailable,int limitPerSale){
        String errorMessage = "";
        errorMessage = String.format("There are %d tickets left.\n", ticketsAvailable);
        errorMessage += "Please only attempt to buy a number of tickets less than or equal to the number available.";
        
        try{
            JOptionPane makeSale = new JOptionPane();
            int canSell = limitPerSale;
            String chosen = "";
            int ticketsSold = 0;
            
            String message = String.format("there are %d tickets available.\n", ticketsAvailable);
            message += "Each sale can be for a maximum of 4 tickets\n";
            message += "please enter the number of tickets you would like to purchase.";
            if(ticketsAvailable < limitPerSale){
                canSell = ticketsAvailable;
                message = String.format("There are only %d tickets left.\n", ticketsAvailable);
                message += "Please enter the number of tickets you would like to purchase.";
            }

            chosen = makeSale.showInputDialog(message);
            
            if(chosen.equals(null)){
                return -1;
            }
            else{
                ticketsSold = Integer.parseInt(chosen);
            }

            if(ticketsSold > canSell){
                
                return makeSale(errorMessage, ticketsAvailable, limitPerSale);
            }
            else{
                return ticketsSold;
            }

        }
        catch(NullPointerException e){
            return -1;
        }
        catch(Exception e){
            e.printStackTrace();
            return makeSale(errorMessage, ticketsAvailable, limitPerSale);
        }
    }

    public static int makeSale(String message, int ticketsAvailable, int limitPerSale){
        try{
            JOptionPane makeSale = new JOptionPane();
            String chosen = "";
            int ticketsSold = 0;
            if(ticketsAvailable > limitPerSale){
                limitPerSale = ticketsAvailable;
                message = String.format("There are only %d tickets left.\n", ticketsAvailable);
                message += "Please enter the number of tickets you would like to purchase.";
            }
    
            chosen = makeSale.showInputDialog(message);
    
            if(chosen.equals(null)){
                return -1;
            }
            else{
                ticketsSold = Integer.parseInt(chosen);
            }

            if(ticketsSold > limitPerSale){
                return makeSale(message, ticketsAvailable, limitPerSale);
            }
            else{
                return ticketsSold;
            }
    
        }
        catch(NullPointerException e){
            return -1;
        }
        catch(Exception e){
            return makeSale(message, ticketsAvailable, limitPerSale);
        }

    }

    public static int findTicketsSold(ArrayList<Integer> sales){
        int result = 0;
        for(int i = 0; i < sales.size(); i++){
            result += sales.get(i);
        }
        return result;
    }


}
