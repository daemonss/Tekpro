package karakter;

import senjata.Pedang;

// Class Prajurit merupakan subclass yang mewarisi class Karakter (Inheritance)
public class Prajurit extends Karakter {
    
    // Konstruktor Prajurit, menggunakan nilai default dan memanggil konstruktor superclass
    public Prajurit(String nama) {
        super(nama, 150, 1, new Pedang(), 20);
    }

    // Implementasi metode abstrak serang dari class Karakter
    @Override
    public void serang(Karakter musuh) {
        System.out.println(nama + " menyerang dengan pedang!");
        int damage = Math.max(0, senjata.serang() - musuh.defense);
        musuh.hp -= damage;
        System.out.println("Damage yang diterima musuh: " + damage);
    }
    
    @Override
    public void bertahan() {
        System.out.println(nama + " mengangkat perisai untuk bertahan!");
        this.defense += 5;
    }
    
    @Override
    public void gunakanSkill() {
        System.out.println(nama + " mengaktifkan skill serangan cepat!");
    }
}
