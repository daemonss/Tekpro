package designpattern.creational.abstractfactory;

public class AutomotiveFactory implements RobotFactory {
    @Override
    public Arm createArm() {
        return new HeavyDutyArm();
    }

    @Override
    public Controller createController() {
        return new IndustrialController();
    }
}
