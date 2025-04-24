import java.time.LocalDateTime;

public abstract class MedicalRecordBase<T extends MedicalRecord.Identifiable> 
    implements MedicalRecord<T> {
    
    private final String recordId; 
    private T data;
    private final LocalDateTime createdAt;

    public MedicalRecordBase(String recordId, T data) {
        validateId(recordId);
        this.recordId = recordId;
        this.data = data;
        this.createdAt = LocalDateTime.now();
    }
    
    // Validasi format ID: 3 huruf besar + 3 angka (contoh: PAT-001)
    private void validateId(String id) {
        if (!id.matches("[A-Z]{3}-\\d{3}")) {
            throw new IllegalArgumentException("Format ID harus 3 huruf + 3 angka (contoh: PAT-001)");
        }
    }
    
    @Override public T getData() { return data; }
    @Override public void setData(T data) { this.data = data; }
    @Override public String getRecordId() { return recordId; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}