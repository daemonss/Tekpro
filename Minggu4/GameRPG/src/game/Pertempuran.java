package game;
import karakter.Karakter;

public class Pertempuran {
    public static void mulai(Karakter k1, Karakter k2) {
        System.out.println("\n=== Pertempuran Dimulai ===");
        k1.serang(k2);
        k2.bertahan();
        k2.serang(k1);
        k1.bertahan();
    }
}
