/**
 * Interface generik untuk semua jenis rekam medis.
 * @param <T> Tipe data yang harus mengimplementasikan Identifiable
 */
public interface MedicalRecord<T extends MedicalRecord.Identifiable> {
    /**
     * Mendapatkan data medis
     */
    T getData();
    
    /**
     * Mengubah data medis
     */
    void setData(T data);
    
    /**
     * Mendapatkan ID unik rekam medis
     */
    String getRecordId();
    
    /**
     * Interface untuk memastikan data memiliki ID
     */
    interface Identifiable {
        String getId();
    }
}