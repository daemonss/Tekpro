package characters;

// Inheritance: Mage adalah subclass dari Character
public class Mage extends Character {
    public Mage(String name) {
        super(name, 80, 100, 8); // HP rendah, Mana tinggi, Speed rendah
    }

    // Metode khusus Mage
    public void castFireball(Character target) {
        if (this.mana >= 30) {
            this.mana -= 30;
            int damage = 35;
            target.takeDamage(damage);
            target.applyStatusEffect(StatusEffect.BURN); // Status effect burn
            System.out.println(name + " menggunakan Fireball pada " + target.getName() + " sebesar " + damage + " damage!");
        } else {
            System.out.println(name + " tidak memiliki cukup mana untuk menggunakan Fireball!");
        }
    }
}