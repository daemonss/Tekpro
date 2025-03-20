package festival;

import java.util.*;
import java.util.concurrent.*;

/**
 * Kelas untuk mengelola festival seni digital.
 * Menggunakan konsep **List**, **Set**, **Map**, **Optional**, **Concurrent Collections**, dan **Immutable Collection**.
 */
public class FestivalManager {
    // List: Menyimpan daftar seniman yang berpartisipasi.
    private final List<Artist> artists = new ArrayList<>();

    // Set: Menyimpan daftar kategori seni unik.
    private final Set<String> categories = ConcurrentHashMap.newKeySet();

    // Map: Menyimpan informasi karya seni yang dipamerkan.
    private final ConcurrentHashMap<String, Artwork> artworks = new ConcurrentHashMap<>();

    // Queue: Mengatur antrian partisipasi seniman.
    private final ParticipationQueue participationQueue = new ParticipationQueue();

    /**
     * Method untuk menambahkan seniman baru.
     * @param artist Seniman yang akan ditambahkan.
     */
    public void addArtist(Artist artist) {
        artists.add(artist); // Tambahkan seniman ke List
        categories.add(artist.kategori()); // Tambahkan kategori ke Set
    }

    /**
     * Method untuk menambahkan karya seni.
     * @param artwork Karya seni yang akan ditambahkan.
     * @return Optional<Artwork> yang berisi karya seni, atau empty jika karya sudah ada.
     */
    public Optional<Artwork> addArtwork(Artwork artwork) {
        return Optional.ofNullable(artworks.putIfAbsent(artwork.id(), artwork)); // Gunakan Optional untuk menangani kasus null
    }

    /**
     * Method untuk menambahkan partisipasi seniman ke antrian.
     * @param artistId ID seniman yang akan berpartisipasi.
     */
    public void addParticipation(String artistId) {
        participationQueue.addParticipation(artistId); // Delegasikan ke ParticipationQueue
    }

    /**
     * Method untuk memproses antrian partisipasi seniman.
     */
    public void processParticipations() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        while (!participationQueue.isEmpty()) {
            String artistId = participationQueue.pollParticipation(); // Ambil dari ParticipationQueue
            executor.submit(() -> {
                System.out.println("Memproses partisipasi seniman: " + artistId);
                // Simulasikan proses partisipasi
                try {
                    Thread.sleep(1000); // Simulasi waktu proses
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Partisipasi selesai: " + artistId);
            });
        }
        executor.shutdown();
    }

    /**
     * Method untuk menampilkan daftar seniman.
     */
    public void displayArtists() {
        artists.forEach(a -> System.out.println("Seniman: " + a.nama() + ", Kategori: " + a.kategori()));
    }

    /**
     * Method untuk menampilkan daftar karya seni.
     */
    public void displayArtworks() {
        artworks.forEach((id, artwork) -> System.out.println("Karya ID: " + id + ", Deskripsi: " + artwork.deskripsi()));
    }
}