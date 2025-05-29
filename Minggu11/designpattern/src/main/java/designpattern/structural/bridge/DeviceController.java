package designpattern.structural.bridge;

public abstract class DeviceController {
    protected Device device;
    
    public DeviceController(Device device) {
        this.device = device;
    }
    
    public abstract void powerOn();
    public abstract void powerOff();
    public abstract void adjustSettings(String settings);
}
