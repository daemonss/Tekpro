package items;

import characters.Character;

// Interface: Item (Kontrak untuk semua item)
public interface Item {
    void use(Character target); // Polymorphism: Bisa HealthPotion, ManaPotion, dll.
    String getEffect();
}