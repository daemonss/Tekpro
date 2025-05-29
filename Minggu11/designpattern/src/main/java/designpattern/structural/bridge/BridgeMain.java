package designpattern.structural.bridge;

public class BridgeMain {
    public static void main(String[] args) {
        // Buat perangkat
        Device lampu = new Light();
        
        // Kontrol via suara
        System.out.println("===== KONTROL SUARA =====");
        DeviceController voiceControl = new VoiceController(lampu);
        voiceControl.powerOn();
        voiceControl.adjustSettings("75%");
        voiceControl.powerOff();
        
        // Kontrol via aplikasi mobile
        System.out.println("\n===== APLIKASI MOBILE =====");
        DeviceController appControl = new MobileAppController(lampu);
        appControl.powerOn();
        appControl.adjustSettings("50%");
        appControl.powerOff();
    }
}
