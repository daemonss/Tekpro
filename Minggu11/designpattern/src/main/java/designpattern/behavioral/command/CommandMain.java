package designpattern.behavioral.command;

public class CommandMain {
    public static void main(String[] args) {
        Kitchen kitchen = new Kitchen();
        Command command = new OrderCommand(kitchen, "Nasi Goreng Spesial");
        
        // Eksekusi perintah
        command.execute();
        
        // Simulasi undo
        System.out.println("\n[USER] Membatalkan pesanan...");
        command.undo();
        
        // Coba undo lagi
        System.out.println("\n[USER] Coba batalkan lagi...");
        command.undo();
    }
}
