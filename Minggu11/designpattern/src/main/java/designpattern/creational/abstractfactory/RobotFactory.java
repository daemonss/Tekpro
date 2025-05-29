package designpattern.creational.abstractfactory;

public interface RobotFactory {
    Arm createArm();
    Controller createController();
}