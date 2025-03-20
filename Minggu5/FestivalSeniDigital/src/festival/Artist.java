package festival;

/**
 * Record untuk menyimpan data seniman.
 * Menggunakan konsep **Record** untuk membuat kelas sederhana dan immutable.
 * @param id        ID unik seniman.
 * @param nama      Nama seniman.
 * @param kategori  Kategori seni yang ditekuni.
 */
public record Artist(String id, String nama, String kategori) {
}