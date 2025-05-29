package designpattern.behavioral.state;

public class StateMain {
    public static void main(String[] args) {
        TicketMachine machine = new TicketMachine(2); // Sediakan 2 tiket
        
        // Test state normal
        System.out.println("\n=== STATE NORMAL ===");
        machine.selectDestination("Bandung");
        machine.insertMoney(30000);
        machine.insertMoney(20000); // Mencukupi, cetak tiket
        
        // Test kurangi tiket
        machine.reduceTicket();
        
        // Test lagi
        System.out.println("\n=== PEMBELIAN KEDUA ===");
        machine.selectDestination("Jakarta");
        machine.insertMoney(50000);
        machine.reduceTicket(); // Habiskan tiket
        
        // Test state habis
        System.out.println("\n=== STATE HABIS ===");
        machine.selectDestination("Surabaya");
        machine.insertMoney(100000);
        
        // Test maintenance
        System.out.println("\n=== MAINTENANCE ===");
        machine.startMaintenance();
        machine.selectDestination("Yogyakarta");
        machine.insertMoney(50000);
        
        // Kembali normal (dengan tambahan tiket)
        System.out.println("\n=== KELUAR MAINTENANCE ===");
        machine.endMaintenance();
        machine.selectDestination("Malang");
    }
}
