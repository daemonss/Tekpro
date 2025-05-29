package designpattern.behavioral.state;

public class MaintenanceState implements TicketState {
    @Override
    public void selectDestination(String destination) {
        System.out.println("Maaf, mesin sedang dalam perbaikan");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Maaf, tidak dapat menerima pembayaran saat ini");
    }

    @Override
    public void printTicket() {
        System.out.println("Tidak dapat mencetak tiket saat ini");
    }
}
