package item;
import karakter.Karakter;

public class Potion extends Item {
    private String tipe; 

    public Potion(String nama, int efek, String tipe) {
        super(nama, efek);
        this.tipe = tipe;
    }

    @Override
    public void gunakan(Karakter karakter) {
        if (tipe.equalsIgnoreCase("HP")) {
            karakter.hp += efek;
        }
    }
}
