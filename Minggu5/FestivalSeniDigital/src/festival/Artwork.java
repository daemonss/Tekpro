package festival;

/**
 * Record untuk menyimpan data karya seni.
 * Menggunakan konsep **Record** untuk membuat kelas sederhana dan immutable.
 * @param id          ID unik karya seni.
 * @param deskripsi   Deskripsi karya seni.
 */
public record Artwork(String id, String deskripsi) {
}