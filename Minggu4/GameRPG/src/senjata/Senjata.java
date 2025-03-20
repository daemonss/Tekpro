package senjata;

// Abstract Class digunakan sebagai dasar untuk semua jenis senjata
public abstract class Senjata {
    protected String nama; // Atribut nama senjata
    protected int damage;  // Atribut damage senjata

    // Konstruktor untuk inisialisasi senjata
    public Senjata(String nama, int damage) {
        this.nama = nama;
        this.damage = damage;
    }

    // Abstract Method serang(), harus diimplementasikan oleh subclass
    public abstract int serang();

    // Getter untuk mendapatkan nama senjata
    public String getNama() {
        return nama;
    }
}
