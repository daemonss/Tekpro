package KoloniMars;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class untuk mengelola misi koloni Mars.
 * Menggunakan ConcurrentHashMap dan Set untuk memastikan thread safety.
 */
public class ManajerMisi {
    // Map: ConcurrentHashMap digunakan untuk menyimpan data misi secara thread-safe.
    private final ConcurrentHashMap<String, Misi> misi;

    // Set: ConcurrentHashMap.newKeySet() digunakan untuk menyimpan ID misi yang gagal secara thread-safe.
    private final Set<String> misiGagal;

    /**
     * Constructor untuk inisialisasi manajer misi.
     */
    public ManajerMisi() {
        this.misi = new ConcurrentHashMap<>();
        this.misiGagal = ConcurrentHashMap.newKeySet(); // Set thread-safe
    }

    /**
     * Method untuk memproses tugas (misi).
     * @param tugas            String yang berisi ID misi dan jumlah sumber daya yang dibutuhkan (contoh: "M001-50").
     * @param manajerSumberDaya Manajer sumber daya untuk mengelola stok.
     */
    public void prosesTugas(String tugas, ManajerSumberDaya manajerSumberDaya) {
        String[] parts = tugas.split("-");
        String idMisi = parts[0];
        int sumberDayaDibutuhkan = Integer.parseInt(parts[1]);

        // Optional: Digunakan untuk menangani pencarian sumber daya yang mungkin tidak ditemukan.
        Optional<SumberDaya> optionalSumberDaya = manajerSumberDaya.kurangiSumberDaya("Oksigen", sumberDayaDibutuhkan);

        optionalSumberDaya.ifPresentOrElse(
            sd -> {
                Misi misiBaru = new Misi(idMisi, "Misi " + idMisi, sumberDayaDibutuhkan, "Selesai");
                misi.put(idMisi, misiBaru);
                System.out.println("Misi " + idMisi + " selesai menggunakan " + sd.nama());
            },
            () -> {
                Misi misiBaru = new Misi(idMisi, "Misi " + idMisi, sumberDayaDibutuhkan, "Gagal: Sumber daya tidak cukup");
                misi.put(idMisi, misiBaru);
                misiGagal.add(idMisi); // Tambahkan ID misi ke Set misiGagal
                System.out.println("Misi " + idMisi + " gagal: Sumber daya tidak cukup");
            }
        );
    }

    /**
     * Method untuk menampilkan daftar misi.
     */
    public void tampilkanMisi() {
        // Menggunakan _ (underscore) untuk parameter yang tidak digunakan (id).
        misi.forEach((_, m) -> System.out.println("Misi: " + m.deskripsi() + ", Status: " + m.status()));
    }

    /**
     * Method untuk menampilkan daftar ID misi yang gagal.
     */
    public void tampilkanMisiGagal() {
        System.out.println("\nMisi yang Gagal:");
        misiGagal.forEach(id -> System.out.println("ID Misi: " + id));
    }
}