package characters;

// Inheritance: Warrior adalah subclass dari Character
public class Warrior extends Character {
    public Warrior(String name) {
        super(name, 100, 50, 10); // HP tinggi, Mana rendah, Speed sedang
    }

    // Metode khusus Warrior
    public void slash(Character target) {
        if (this.mana >= 20) {
            this.mana -= 20;
            int damage = 25;
            target.takeDamage(damage);
            System.out.println(name + " menggunakan Slash pada " + target.getName() + " sebesar " + damage + " damage!");
        } else {
            System.out.println(name + " tidak memiliki cukup mana untuk menggunakan Slash!");
        }
    }
}