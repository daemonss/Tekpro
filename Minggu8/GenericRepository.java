import java.util.ArrayList;
import java.util.List;

/**
 * Repository generik untuk menyimpan dan mengelola rekam medis.
 * @param <T> Tipe rekam medis yang disimpan (harus turunan MedicalRecord)
 */
public class GenericRepository<T extends MedicalRecord<?>> {
    private final List<T> records = new ArrayList<>(); // Menggunakan tipe T

    /**
     * Menambahkan rekam medis baru
     */
    public void addRecord(T record) {
        records.add(record);
    }

    /**
     * Mengambil semua rekam medis (return copy untuk keamanan)
     */
    public List<T> getAllRecords() {
        return new ArrayList<>(records); // Defensive copy
    }

    /**
     * Mencetak semua rekam medis dalam repository
     */
    public static void printAll(GenericRepository<?> repository) {
        repository.records.forEach(System.out::println);
    }

    /**
     * Method khusus untuk memproses hasil lab
     */
    public static void processLabReports(GenericRepository<? extends LabResult> labRepo) {
        labRepo.records.forEach(lab -> 
            System.out.println("Nilai Lab: " + lab.getData().getId())
        );
    }
}