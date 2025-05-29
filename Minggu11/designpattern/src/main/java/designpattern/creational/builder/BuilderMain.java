package designpattern.creational.builder;

public class BuilderMain {
    public static void main(String[] args) {
        // Build drone dengan konfigurasi minimal
        Drone basicDrone = new Drone.Builder("DJI Mini 2")
                .build();
        System.out.println("Basic Drone: " + basicDrone);
        
        // Build drone dengan konfigurasi lengkap
        Drone premiumDrone = new Drone.Builder("DJI Mavic 3 Pro")
                .setCamera("Hasselblad 4K")
                .setBattery("5000mAh Ultra")
                .setControllerType("Smart Controller")
                .build();
        System.out.println("\nPremium Drone: " + premiumDrone);
        
        // Validasi parameter wajib
        try {
            Drone invalidDrone = new Drone.Builder("")
                    .build();
            System.out.println("\nInvalid Drone: " + invalidDrone);
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}