package festival;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * Kelas untuk mengelola antrian partisipasi seniman.
 * Menggunakan konsep **Queue dan Dequeue** serta **Concurrent Collections**.
 */
public class ParticipationQueue {
    // Deque: ConcurrentLinkedDeque digunakan untuk mengantre partisipasi secara thread-safe.
    private final Deque<String> queue = new ConcurrentLinkedDeque<>();

    /**
     * Method untuk menambahkan partisipasi seniman ke antrian.
     * @param artistId ID seniman yang akan berpartisipasi.
     */
    public void addParticipation(String artistId) {
        queue.addLast(artistId); // Tambahkan seniman ke belakang antrian
    }

    /**
     * Method untuk mengambil partisipasi seniman dari antrian.
     * @return ID seniman yang diambil, atau null jika antrian kosong.
     */
    public String pollParticipation() {
        return queue.pollFirst(); // Ambil seniman dari depan antrian
    }

    /**
     * Method untuk mengecek apakah antrian kosong.
     * @return true jika antrian kosong, false jika tidak.
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}