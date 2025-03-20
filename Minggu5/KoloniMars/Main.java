package KoloniMars;

import java.util.concurrent.*;

/**
 * Class utama untuk menjalankan simulasi koloni Mars.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Inisialisasi manajer
        ManajerSumberDaya manajerSumberDaya = new ManajerSumberDaya();
        ManajerPenduduk manajerPenduduk = new ManajerPenduduk();
        ManajerMisi manajerMisi = new ManajerMisi();
        AntrianTugas antrianTugas = new AntrianTugas();

        // Menambahkan sumber daya
        manajerSumberDaya.tambahSumberDaya("Oksigen", 1200);
        manajerSumberDaya.tambahSumberDaya("Air", 500);
        manajerSumberDaya.tambahSumberDaya("Makanan", 300);

        // Menambahkan penduduk
        manajerPenduduk.tambahPenduduk("P001", "Alice", "Insinyur", true);
        manajerPenduduk.tambahPenduduk("P002", "Bob", "Ahli Botani", true);
        manajerPenduduk.tambahPenduduk("P003", "Charlie", "Dokter", false);

        // Menambahkan misi ke antrian
        antrianTugas.tambahTugasBelakang("M001-50");
        antrianTugas.tambahTugasDepan("M002-30");
        antrianTugas.tambahTugasBelakang("M003-20");
        antrianTugas.tambahTugasDepan("M004-100");

        // Memproses antrian tugas
        ExecutorService executor = Executors.newFixedThreadPool(2);
        while (!antrianTugas.isEmpty()) {
            String tugas = antrianTugas.ambilTugasDepan();
            executor.submit(() -> manajerMisi.prosesTugas(tugas, manajerSumberDaya));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        // Menampilkan hasil
        manajerSumberDaya.tampilkanSumberDaya();
        manajerPenduduk.tampilkanPenduduk();
        manajerMisi.tampilkanMisi();
        manajerMisi.tampilkanMisiGagal(); // Menampilkan misi yang gagal
    }
}