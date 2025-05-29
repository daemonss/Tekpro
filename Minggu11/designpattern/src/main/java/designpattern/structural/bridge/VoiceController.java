package designpattern.structural.bridge;

public class VoiceController extends DeviceController {
    public VoiceController(Device device) {
        super(device);
    }
    
    @Override
    public void powerOn() {
        System.out.println("Perintah suara: Nyalakan perangkat");
        device.turnOn();
    }
    
    @Override
    public void powerOff() {
        System.out.println("Perintah suara: Matikan perangkat");
        device.turnOff();
    }
    
    @Override
    public void adjustSettings(String settings) {
        System.out.println("Perintah suara: Atur pengaturan ke " + settings);
        device.setSettings(settings);
    }
}
