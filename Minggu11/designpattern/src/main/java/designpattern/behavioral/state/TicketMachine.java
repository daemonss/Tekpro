package designpattern.behavioral.state;

public class TicketMachine {
    private TicketState state;
    private int ticketCount;

    public TicketMachine(int initialTickets) {
        this.ticketCount = initialTickets;
        this.state = new AvailableState(this);
    }

    public void setState(TicketState state) {
        this.state = state;
    }

    public void selectDestination(String destination) {
        state.selectDestination(destination);
    }

    public void insertMoney(double amount) {
        state.insertMoney(amount);
    }

    public void printTicket() {
        state.printTicket();
    }
    
    public void reduceTicket() {
        if(ticketCount > 0) {
            ticketCount--;
            System.out.println("Sisa tiket: " + ticketCount);
            
            if(ticketCount == 0) {
                setState(new SoldOutState());
            }
        }
    }
    
    public void startMaintenance() {
        setState(new MaintenanceState());
        System.out.println("Mode perbaikan diaktifkan");
    }
    
    public void endMaintenance() {
        setState(new AvailableState(this));
        System.out.println("Mode perbaikan dinonaktifkan");
    }
}
