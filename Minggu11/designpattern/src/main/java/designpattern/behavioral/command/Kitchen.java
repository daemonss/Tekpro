package designpattern.behavioral.command;

public class Kitchen {
    public void prepareOrder(String order) {
        System.out.println("[KITCHEN] Memasak: " + order);
    }
    
    public void cancelOrder(String order) {
        System.out.println("[KITCHEN] Membatalkan: " + order);
    }
}
