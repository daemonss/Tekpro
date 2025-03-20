package karakter;

// Interface Aksi berisi method yang harus diimplementasikan oleh setiap karakter
public interface Aksi {
    void serang(Karakter musuh); // Setiap karakter harus bisa menyerang
    void bertahan(); // Setiap karakter harus bisa bertahan
}
