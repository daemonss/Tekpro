package senjata;

// TongkatSihir mewarisi class Senjata
public class TongkatSihir extends Senjata {
    
    public TongkatSihir() {
        super("Tongkat Sihir Petir", 40); // Memanggil konstruktor superclass
    }

    // Implementasi metode abstrak serang()
    @Override
    public int serang() {
        System.out.println("Melepaskan kilat sihir dari tongkat!");
        return damage + 10; // Bonus serangan sihir
    }
}
