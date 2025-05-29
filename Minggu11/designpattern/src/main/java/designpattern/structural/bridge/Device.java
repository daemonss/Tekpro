package designpattern.structural.bridge;

// Implementor
public interface Device {
    void turnOn();
    void turnOff();
    void setSettings(String settings);
}
