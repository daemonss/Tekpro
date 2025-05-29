package designpattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class ProductBundle implements InventoryItem {
    private final List<InventoryItem> items = new ArrayList<>();
    
    public void addItem(InventoryItem item) {
        items.add(item);
    }
    
    @Override
    public double getPrice() {
        double total = 0;
        for (InventoryItem item : items) {
            total += item.getPrice();
        }
        return total;
    }
}
