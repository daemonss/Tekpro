package KoloniMars;

/**
 * Record untuk menyimpan data misi.
 * @param id                  ID unik misi.
 * @param deskripsi           Deskripsi misi.
 * @param sumberDayaDibutuhkan Jumlah sumber daya yang dibutuhkan untuk menyelesaikan misi.
 * @param status              Status misi (contoh: "Selesai", "Gagal").
 */
public record Misi(String id, String deskripsi, int sumberDayaDibutuhkan, String status) {
    /**
     * Method untuk mengupdate status misi.
     * @param statusBaru Status baru misi.
     * @return Misi baru dengan status yang diupdate.
     */
    public Misi updateStatus(String statusBaru) {
        return new Misi(id, deskripsi, sumberDayaDibutuhkan, statusBaru);
    }
}