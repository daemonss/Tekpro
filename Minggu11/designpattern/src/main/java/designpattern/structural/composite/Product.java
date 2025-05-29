package designpattern.structural.composite;

public class Product implements InventoryItem {
    private final double price;
    
    public Product(double price) {
        this.price = price;
    }
    
    @Override
    public double getPrice() {
        return price;
    }
}
