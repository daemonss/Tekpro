package designpattern.creational.builder;

public class Drone {
    private final String model;  // Parameter wajib
    private final String camera;
    private final String battery;
    private final String controllerType;
    
    private Drone(Builder builder) {
        this.model = builder.model;
        this.camera = builder.camera;
        this.battery = builder.battery;
        this.controllerType = builder.controllerType;
    }
    
    // Getter methods
    public String getModel() { return model; }
    public String getCamera() { return camera; }
    public String getBattery() { return battery; }
    public String getControllerType() { return controllerType; }
    
    @Override
    public String toString() {
        return "Drone [Model: " + model + 
               ", Camera: " + camera + 
               ", Battery: " + battery + 
               ", Controller: " + controllerType + "]";
    }

    public static class Builder {
        // Wajib diinisialisasi
        private final String model;
        
        // Opsional dengan nilai default
        private String camera = "4K Basic";
        private String battery = "3000mAh";
        private String controllerType = "Standard";
        
        // Constructor dengan parameter wajib
        public Builder(String model) {
            if(model == null || model.isBlank()) {
                throw new IllegalArgumentException("Model tidak boleh kosong");
            }
            this.model = model;
        }
        
        public Builder setCamera(String camera) {
            if(camera != null) {
                this.camera = camera;
            }
            return this;
        }
        
        public Builder setBattery(String battery) {
            if(battery != null) {
                this.battery = battery;
            }
            return this;
        }
        
        public Builder setControllerType(String controllerType) {
            if(controllerType != null) {
                this.controllerType = controllerType;
            }
            return this;
        }
        
        public Drone build() {
            return new Drone(this);
        }
    }
}