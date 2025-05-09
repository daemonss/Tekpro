package daemons;


public class Passanger {
    private String name;
    private boolean vip;

    public Passanger(String name, boolean vip) {
        this.name = name;
        this.vip = vip;
    }

    public String getName() {
        return name;
    }

    public boolean isVip() {
        return vip;
    }
}
