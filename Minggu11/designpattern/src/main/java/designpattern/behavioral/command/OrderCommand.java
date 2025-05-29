package designpattern.behavioral.command;

public class OrderCommand implements Command {
    private final Kitchen kitchen;
    private final String order;
    private boolean executed = false;

    public OrderCommand(Kitchen kitchen, String order) {
        this.kitchen = kitchen;
        this.order = order;
    }

    @Override
    public void execute() {
        kitchen.prepareOrder(order);
        executed = true;
    }

    @Override
    public void undo() {
        if(executed) {
            kitchen.cancelOrder(order);
            executed = false;
        } else {
            System.out.println("[WARNING] Pesanan belum dieksekusi");
        }
    }
}
