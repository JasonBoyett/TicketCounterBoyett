import javax.swing.JOptionPane;

public interface SellsTickets{
    

    public void addSale(int amountSold);
    
    public default void sellTickets(TicketPool ticketPool){
        try{
            do{
                if(ticketPool.getAvailableTicket() <= 0){
                    break;
                }
                else{
                int thisSale = makeSale(ticketPool.getAvailableTicket(),ticketPool.getMaxPerSale());
                if(thisSale <= 0){
                    break;
                }
                ticketPool.addSale(thisSale);
            }
            }while(true);
            
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
    }


    public default int makeSale(int ticketsAvailable,int limitPerSale){
        String errorMessage = "";
        errorMessage = String.format("There are %d tickets left.\n", ticketsAvailable);
        errorMessage += String.format("Limit :%d tickets per sale\n", limitPerSale);
        errorMessage += "Please only attempt to buy a number of tickets less than or equal to the number available.";
        
        try{
            String chosen = "";
            int ticketsSold = 0;
            
            String message = String.format("there are %d tickets available.\n", ticketsAvailable);
            message += "Each sale can be for a maximum of 4 tickets\n";
            message += "please enter the number of tickets you would like to purchase.";
            if(ticketsAvailable < 0){
                return -1;
            }
            if(ticketsAvailable < limitPerSale){
                limitPerSale = ticketsAvailable;
                message = String.format("There are only %d tickets left.\n", ticketsAvailable);
                message += "Please enter the number of tickets you would like to purchase.";
            }

            chosen = JOptionPane.showInputDialog(message);
            
            if(chosen.equals(null)){
                return -1;
            }
            else{
                ticketsSold = Integer.parseInt(chosen);
            }
            
            if(ticketsSold > limitPerSale){
                return makeSale(errorMessage, ticketsAvailable, limitPerSale); 
            }
            if(ticketsSold > ticketsAvailable){

                while(ticketsSold > ticketsAvailable){
                    ticketsSold = makeSale(errorMessage, ticketsAvailable, limitPerSale);
                }
                
                return ticketsSold;
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

    public default int makeSale(String message, int ticketsAvailable, int limitPerSale){
        try{

            String chosen = "";
            int ticketsSold = 0;
            if(ticketsAvailable < limitPerSale){
                
                limitPerSale = ticketsAvailable;
                message = String.format("There are only %d tickets left.\n", ticketsAvailable);
                message += "The tickets cannot be over sold\n";
                message += "Please enter the number of tickets you would like to purchase.";

            }

            chosen = JOptionPane.showInputDialog(message);
    
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
}