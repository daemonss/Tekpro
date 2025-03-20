package senjata;

// Pedang adalah subclass yang mewarisi abstract class Senjata
public class Pedang extends Senjata {
    
    public Pedang() {
        super("Pedang Baja", 30); // Memanggil konstruktor superclass (Senjata)
    }

    // Implementasi metode abstrak serang()
    @Override
    public int serang() {
        System.out.println("Mengayunkan pedang dengan kekuatan penuh!");
        return damage;
    }
}
