package items;

import characters.Character;

// Implementasi Interface: HealthPotion
public class HealthPotion implements Item {
    @Override
    public void use(Character target) {
        int healAmount = 50;
        target.setHealth(target.getHealth() + healAmount);
        System.out.println(target.getName() + " healed for " + healAmount + " HP!");
    }

    @Override
    public String getEffect() {
        return "Heals 50 HP";
    }
}