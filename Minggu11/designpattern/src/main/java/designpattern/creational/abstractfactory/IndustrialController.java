package designpattern.creational.abstractfactory;

public class IndustrialController implements Controller {
    @Override
    public void process() {
        System.out.println("Mengontrol dengan presisi tinggi");
    }
}