package designpattern.creational.abstractfactory;

public class AbstractFactoryMain {
    public static void main(String[] args) {
        RobotFactory factory = new AutomotiveFactory();
        Arm arm = factory.createArm();
        arm.lift();
        
        Controller controller = factory.createController();
        controller.process();
    }
}