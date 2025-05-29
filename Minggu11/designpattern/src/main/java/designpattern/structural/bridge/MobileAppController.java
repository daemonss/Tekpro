package designpattern.structural.bridge;

public class MobileAppController extends DeviceController {
    public MobileAppController(Device device) {
        super(device);
    }
    
    @Override
    public void powerOn() {
        System.out.println("Aplikasi Mobile: Mengaktifkan perangkat");
        device.turnOn();
    }
    
    @Override
    public void powerOff() {
        System.out.println("Aplikasi Mobile: Menonaktifkan perangkat");
        device.turnOff();
    }
    
    @Override
    public void adjustSettings(String settings) {
        System.out.println("Aplikasi Mobile: Mengubah konfigurasi ke " + settings);
        device.setSettings(settings);
    }
}
