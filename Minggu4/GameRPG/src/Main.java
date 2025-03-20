package src;

import karakter.*;
import item.*;
import senjata.*;
import game.*;
import game.Pertempuran;


public class Main {
    public static void main(String[] args) {
        // Membuat karakter Prajurit dan Penyihir (Menggunakan Polymorphism)
        Karakter prajurit = new Prajurit("Morgan");
        Karakter penyihir = new Penyihir("Merlin");

        // Menampilkan informasi awal karakter
        System.out.println("\n=== Informasi Awal Karakter ===");
        prajurit.info();
        penyihir.info();

        // Membeli dan menggunakan item Potion
        System.out.println("\n=== Pembelian Item ===");
        prajurit.beliItem(new Potion("Ramuan HP", 30, "HP"), 50);
        penyihir.beliItem(new Potion("Ramuan Mana", 25, "Mana"), 50);

        // Menggunakan item dari inventory
        System.out.println("\n=== Menggunakan Item ===");
        prajurit.gunakanItem(0);
        penyihir.gunakanItem(0);

        // Penyihir menggunakan sihir (Hanya Penyihir yang bisa)
        if (penyihir instanceof Penyihir) {
            ((Penyihir) penyihir).gunakanSihir();
        }

        // Memulai pertempuran
        System.out.println("\n=== Pertempuran Dimulai ===");
        Pertempuran.mulai(prajurit, penyihir);

        // Karakter naik level setelah bertarung
        System.out.println("\n=== Level Up ===");
        prajurit.levelUp();
        penyihir.levelUp();

        // Menampilkan informasi karakter setelah bertarung
        System.out.println("\n=== Informasi Akhir Karakter ===");
        prajurit.info();
        penyihir.info();
    }
}
