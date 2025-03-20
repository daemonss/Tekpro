package karakter;

import senjata.TongkatSihir;

// Penyihir mewarisi class Karakter dan mengimplementasikan interface PenyihirInterface
public class Penyihir extends Karakter implements PenyihirInterface {
    
    public Penyihir(String nama) {
        super(nama, 100, 1, new TongkatSihir(), 10);
    }

    @Override
    public void serang(Karakter musuh) {
        System.out.println(nama + " menyerang dengan sihir!");
        int damage = Math.max(0, senjata.serang() - musuh.defense);
        musuh.hp -= damage;
        System.out.println("Damage yang diterima musuh: " + damage);
    }
    
    // Implementasi metode dari interface PenyihirInterface
    @Override
    public void gunakanSihir() {
        System.out.println(nama + " memanggil badai petir!");
        this.hp += 10;
    }
    
    @Override
    public void bertahan() {
        System.out.println(nama + " membuat perisai energi!");
        this.defense += 8;
    }
}
