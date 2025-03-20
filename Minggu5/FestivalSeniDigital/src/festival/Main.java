package festival;

import java.util.concurrent.TimeUnit;

/**
 * Class utama untuk menjalankan simulasi festival seni digital.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        FestivalManager festivalManager = new FestivalManager();

        // Menambahkan seniman
        festivalManager.addArtist(new Artist("A001", "Alice", "Digital Art"));
        festivalManager.addArtist(new Artist("A002", "Bob", "Virtual Reality"));

        // Menambahkan karya seni
        festivalManager.addArtwork(new Artwork("K001", "Karya Digital Alice"));
        festivalManager.addArtwork(new Artwork("K002", "Karya VR Bob"));

        // Menambahkan partisipasi seniman ke antrian
        festivalManager.addParticipation("A001");
        festivalManager.addParticipation("A002");

        // Memproses antrian partisipasi seniman
        festivalManager.processParticipations();

        // Menampilkan daftar seniman dan karya seni
        festivalManager.displayArtists();
        festivalManager.displayArtworks();

        // Contoh penggunaan TimeUnit
        TimeUnit.SECONDS.sleep(2); // Menunggu 2 detik
    }
}