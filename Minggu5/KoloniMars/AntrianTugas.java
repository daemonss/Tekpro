package KoloniMars;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Class untuk mengelola antrian tugas (misi) dengan Dequeue.
 * Menggunakan ConcurrentLinkedDeque untuk memastikan thread safety.
 */
public class AntrianTugas {
    // Deque: ConcurrentLinkedDeque digunakan untuk mengantre tugas secara thread-safe.
    private final Deque<String> antrian;

    /**
     * Constructor untuk inisialisasi antrian tugas.
     */
    public AntrianTugas() {
        this.antrian = new ConcurrentLinkedDeque<>();
    }

    /**
     * Method untuk menambahkan tugas ke depan antrian.
     * @param tugas Tugas yang akan ditambahkan (contoh: "M001-50").
     */
    public void tambahTugasDepan(String tugas) {
        antrian.addFirst(tugas);
    }

    /**
     * Method untuk menambahkan tugas ke belakang antrian.
     * @param tugas Tugas yang akan ditambahkan (contoh: "M001-50").
     */
    public void tambahTugasBelakang(String tugas) {
        antrian.addLast(tugas);
    }

    /**
     * Method untuk mengambil tugas dari depan antrian.
     * @return Tugas yang diambil, atau null jika antrian kosong.
     */
    public String ambilTugasDepan() {
        return antrian.pollFirst();
    }

    /**
     * Method untuk mengambil tugas dari belakang antrian.
     * @return Tugas yang diambil, atau null jika antrian kosong.
     */
    public String ambilTugasBelakang() {
        return antrian.pollLast();
    }

    /**
     * Method untuk mengecek apakah antrian kosong.
     * @return true jika antrian kosong, false jika tidak.
     */
    public boolean isEmpty() {
        return antrian.isEmpty();
    }
}