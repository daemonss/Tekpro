package designpattern.behavioral.state;

public class AvailableState implements TicketState {
    private final TicketMachine machine;
    private String destination;
    private double amountPaid;
    private final double TICKET_PRICE = 50000;

    public AvailableState(TicketMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectDestination(String destination) {
        this.destination = destination;
        System.out.println("Tujuan dipilih: " + destination);
    }

    @Override
    public void insertMoney(double amount) {
        amountPaid += amount;
        System.out.println("Diterima: Rp" + amount);
        
        if(amountPaid >= TICKET_PRICE) {
            printTicket();
            machine.setState(new AvailableState(machine)); // Kembali ke state awal
        } else {
            System.out.println("Kurang: Rp" + (TICKET_PRICE - amountPaid));
        }
    }

    @Override
    public void printTicket() {
        System.out.println("=================================");
        System.out.println("TIKET KERETA");
        System.out.println("Tujuan: " + destination);
        System.out.println("Harga: Rp" + TICKET_PRICE);
        System.out.println("=================================");
    }
}
