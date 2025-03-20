package skills;

import characters.Character;
import characters.StatusEffect; // Import enum StatusEffect

// Implementasi Interface: Fireball
public class Fireball implements Skill {
    @Override
    public void activate(Character user, Character target) {
        int damage = 35;
        target.takeDamage(damage);
        target.applyStatusEffect(StatusEffect.BURN); // Terapkan status effect BURN
        System.out.println(user.getName() + " menggunakan Fireball pada " + target.getName() + " sebesar " + damage + " damage!");
    }

    @Override
    public int getManaCost() { // Perbaiki typo: getNameCost() -> getManaCost()
        return 30;
    }
}