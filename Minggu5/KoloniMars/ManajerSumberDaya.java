package KoloniMars;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class untuk mengelola sumber daya koloni Mars.
 * Menggunakan ConcurrentHashMap untuk memastikan thread safety.
 */
public class ManajerSumberDaya {
    // Map: ConcurrentHashMap digunakan untuk menyimpan data sumber daya secara thread-safe.
    private final ConcurrentHashMap<String, SumberDaya> sumberDaya;

    /**
     * Constructor untuk inisialisasi manajer sumber daya.
     */
    public ManajerSumberDaya() {
        this.sumberDaya = new ConcurrentHashMap<>();
    }

    /**
     * Method untuk menambahkan sumber daya baru.
     * @param nama   Nama sumber daya.
     * @param jumlah Jumlah sumber daya.
     */
    public void tambahSumberDaya(String nama, int jumlah) {
        sumberDaya.put(nama, new SumberDaya(nama, jumlah));
    }

    /**
     * Method untuk mengurangi jumlah sumber daya.
     * @param nama   Nama sumber daya.
     * @param jumlah Jumlah yang akan dikurangi.
     * @return Optional<SumberDaya> yang berisi sumber daya yang sudah dikurangi, atau empty jika sumber daya tidak ditemukan.
     */
    public Optional<SumberDaya> kurangiSumberDaya(String nama, int jumlah) {
        // Optional: Digunakan untuk menangani pencarian sumber daya yang mungkin tidak ditemukan.
        return Optional.ofNullable(sumberDaya.computeIfPresent(nama, (_, v) -> {
            if (v.jumlah() >= jumlah) {
                return v.kurangi(jumlah);
            } else {
                return null; // Kembalikan null jika sumber daya tidak cukup
            }
        }));
    }

    /**
     * Method untuk menampilkan daftar sumber daya dan jumlahnya.
     */
    public void tampilkanSumberDaya() {
        sumberDaya.forEach((nama, sd) -> System.out.println("Sumber Daya: " + nama + ", Jumlah: " + sd.jumlah()));
    }
}