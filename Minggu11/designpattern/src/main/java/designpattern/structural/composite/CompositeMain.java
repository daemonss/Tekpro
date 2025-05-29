package designpattern.structural.composite;

public class CompositeMain {
    public static void main(String[] args) {
        Product komputer = new Product(8000000);
        Product monitor = new Product(2500000);
        
        ProductBundle paket = new ProductBundle();
        paket.addItem(komputer);
        paket.addItem(monitor);
        
        System.out.println("Total harga paket: Rp" + paket.getPrice());
    }
}
