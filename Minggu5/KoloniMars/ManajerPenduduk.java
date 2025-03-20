package KoloniMars;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class untuk mengelola penduduk koloni Mars.
 * Menggunakan ConcurrentHashMap untuk memastikan thread safety.
 */
public class ManajerPenduduk {
    // Map: ConcurrentHashMap digunakan untuk menyimpan data penduduk secara thread-safe.
    private final ConcurrentHashMap<String, Penduduk> penduduk;

    /**
     * Constructor untuk inisialisasi manajer penduduk.
     */
    public ManajerPenduduk() {
        this.penduduk = new ConcurrentHashMap<>();
    }

    /**
     * Method untuk menambahkan penduduk baru.
     * @param id        ID penduduk.
     * @param nama      Nama penduduk.
     * @param pekerjaan Pekerjaan penduduk.
     * @param sehat     Status kesehatan penduduk.
     */
    public void tambahPenduduk(String id, String nama, String pekerjaan, boolean sehat) {
        // Immutable Collections: List.of() digunakan untuk inisialisasi riwayat peminjaman.
        penduduk.put(id, new Penduduk(id, nama, pekerjaan, sehat, List.of()));
    }

    /**
     * Method untuk menampilkan daftar penduduk.
     */
    public void tampilkanPenduduk() {
        // Menggunakan _ (underscore) untuk parameter yang tidak digunakan (id).
        penduduk.forEach((_, p) -> System.out.println("Penduduk: " + p.nama() + ", Pekerjaan: " + p.pekerjaan() + ", Sehat: " + p.sehat()));
    }
}