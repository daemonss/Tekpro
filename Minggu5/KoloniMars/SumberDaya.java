package KoloniMars;

/**
 * Record untuk menyimpan data sumber daya.
 * @param nama   Nama sumber daya (contoh: Oksigen, Air, Makanan).
 * @param jumlah Jumlah sumber daya yang tersedia.
 */
public record SumberDaya(String nama, int jumlah) {
    /**
     * Method untuk mengurangi jumlah sumber daya.
     * @param jumlah Jumlah yang akan dikurangi.
     * @return SumberDaya baru dengan jumlah yang sudah dikurangi.
     */
    public SumberDaya kurangi(int jumlah) {
        return new SumberDaya(nama, this.jumlah - jumlah);
    }
}