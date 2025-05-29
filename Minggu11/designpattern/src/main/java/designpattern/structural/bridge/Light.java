package designpattern.structural.bridge;

public class Light implements Device {
    // HAPUS field isOn jika tidak digunakan
    private String brightness = "100%";

    @Override
    public void turnOn() {
        System.out.println("Lampu dinyalakan");  // HAPUS x:
    }

    @Override
    public void turnOff() {
        System.out.println("Lampu dimatikan");  // HAPUS x:
    }

    @Override
    public void setSettings(String settings) {
        this.brightness = settings;
        System.out.println("Kecerahan diatur ke: " + brightness);
    }
    
    // TAMBAHKAN jika perlu akses brightness
    public String getBrightness() {
        return brightness;
    }
}
