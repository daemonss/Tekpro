package item;
import karakter.Karakter;

// Superclass untuk item
public class Item {
    protected String nama;
    protected int efek;

    public Item(String nama, int efek) {
        this.nama = nama;
        this.efek = efek;
    }

    public String getNama() {
        return nama;
    }

    public void gunakan(Karakter karakter) {
        karakter.hp += efek;
        System.out.println(karakter.nama + " menggunakan " + nama + ". HP bertambah " + efek);
    }
}
