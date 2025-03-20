package karakter;

import senjata.Senjata;
import item.Item;
import java.util.ArrayList;
import java.util.List;

// Abstract Class Karakter digunakan sebagai cetakan umum untuk semua karakter dalam game
// Inheritance: Class ini akan diwarisi oleh class Prajurit dan Penyihir
public abstract class Karakter {
    protected String nama; // Nama karakter
    protected int hp; // Health Points (HP) karakter
    protected int level; // Level karakter
    protected Senjata senjata; // Senjata yang digunakan karakter (menggunakan konsep Composition)
    protected int defense; // Nilai pertahanan karakter
    protected List<Item> inventory; // Daftar item yang dimiliki karakter
    protected int gold; // Mata uang dalam game untuk membeli item

    // Konstruktor untuk inisialisasi atribut karakter
    public Karakter(String nama, int hp, int level, Senjata senjata, int defense) {
        this.nama = nama;
        this.hp = hp;
        this.level = level;
        this.senjata = senjata;
        this.defense = defense;
        this.inventory = new ArrayList<>();
        this.gold = 100; // Set default gold
    }

    // Abstract Methods: Harus diimplementasikan oleh subclass yang mewarisi class ini
    public abstract void serang(Karakter musuh); // Polymorphism: Setiap subclass memiliki cara menyerang yang berbeda
    public abstract void bertahan();
    public abstract void gunakanSkill();

    // Method untuk menambahkan item ke dalam inventory
    public void tambahItem(Item item) {
        inventory.add(item);
        System.out.println(nama + " mendapatkan item: " + item.getNama());
    }

    // Method untuk menggunakan item dari inventory
    public void gunakanItem(int index) {
        if (index >= 0 && index < inventory.size()) {
            Item item = inventory.get(index);
            item.gunakan(this);
            inventory.remove(index);
        } else {
            System.out.println("Item tidak ditemukan!");
        }
    }

    // Method untuk membeli item menggunakan gold
    public void beliItem(Item item, int harga) {
        if (gold >= harga) {
            gold -= harga;
            tambahItem(item);
            System.out.println(nama + " membeli " + item.getNama() + " seharga " + harga + " gold.");
        } else {
            System.out.println("Gold tidak cukup!");
        }
    }

    // Method untuk meningkatkan level karakter
    public void levelUp() {
        level++;
        hp += 20;
        defense += 5;
        gold += 50;
        System.out.println(nama + " naik level! Sekarang level: " + level);
    }

    // Menampilkan informasi karakter
    public void info() {
        System.out.println(nama + " - HP: " + hp + ", Level: " + level + ", Senjata: " + senjata.getNama() + ", Defense: " + defense + ", Gold: " + gold);
    }
}
