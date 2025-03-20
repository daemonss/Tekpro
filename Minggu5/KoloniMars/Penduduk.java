package KoloniMars;

import java.util.ArrayList;
import java.util.List;

/**
 * Record untuk menyimpan data penduduk.
 * @param id        ID unik penduduk.
 * @param nama      Nama penduduk.
 * @param pekerjaan Pekerjaan penduduk (contoh: Insinyur, Ahli Botani).
 * @param sehat     Status kesehatan penduduk (true jika sehat, false jika sakit).
 * @param riwayatPeminjaman Daftar ID misi yang pernah diambil oleh penduduk.
 */
public record Penduduk(String id, String nama, String pekerjaan, boolean sehat, List<String> riwayatPeminjaman) {
    // List: Digunakan untuk menyimpan riwayat peminjaman.
    // Immutable Collections: List.of() digunakan untuk inisialisasi riwayat peminjaman.

    /**
     * Constructor untuk inisialisasi riwayatPeminjaman jika null.
     */
    public Penduduk {
        if (riwayatPeminjaman == null) {
            riwayatPeminjaman = List.of(); // Inisialisasi dengan List.of()
        }
    }

    /**
     * Method untuk mengubah status kesehatan penduduk menjadi sehat.
     * @return Penduduk baru dengan status sehat.
     */
    public Penduduk pulihkan() {
        return new Penduduk(id, nama, pekerjaan, true, riwayatPeminjaman);
    }

    /**
     * Method untuk menambahkan ID misi ke riwayat peminjaman.
     * @param idMisi ID misi yang akan ditambahkan.
     * @return Penduduk baru dengan riwayat peminjaman yang diperbarui.
     */
    public Penduduk tambahRiwayat(String idMisi) {
        List<String> riwayatBaru = new ArrayList<>(riwayatPeminjaman); // Buat salinan riwayatPeminjaman
        riwayatBaru.add(idMisi); // Tambahkan ID misi ke riwayatBaru
        return new Penduduk(id, nama, pekerjaan, sehat, riwayatBaru); // Kembalikan Penduduk baru
    }
}