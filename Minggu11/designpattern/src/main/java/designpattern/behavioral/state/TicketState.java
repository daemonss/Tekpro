package designpattern.behavioral.state;

public interface TicketState {
    void selectDestination(String destination);
    void insertMoney(double amount);
    void printTicket();
}
