package designpattern.behavioral.state;

public class SoldOutState implements TicketState {
    @Override
    public void selectDestination(String destination) {
        System.out.println("Maaf, tiket untuk semua tujuan sudah habis");
    }

    @Override
    public void insertMoney(double amount) {
        System.out.println("Tidak dapat menerima pembayaran karena tiket habis");
    }

    @Override
    public void printTicket() {
        System.out.println("Tidak ada tiket yang bisa dicetak");
    }
}