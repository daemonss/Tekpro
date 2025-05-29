package designpattern.creational.abstractfactory;

public class HeavyDutyArm implements Arm {
    @Override
    public void lift() {
        System.out.println("Mengangkat 500kg");
    }
}