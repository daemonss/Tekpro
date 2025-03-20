package items;

import characters.Character;

// Implementasi Interface: ManaPotion
public class ManaPotion implements Item {
    @Override
    public void use(Character target) {
        int manaAmount = 30;
        target.setMana(target.getMana() + manaAmount);
        System.out.println(target.getName() + " restored " + manaAmount + " mana!");
    }

    @Override
    public String getEffect() {
        return "Restores 30 Mana";
    }
}