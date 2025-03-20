package skills;

import characters.Character;

// Implementasi Interface: Slash
public class Slash implements Skill {
    @Override
    public void activate(Character user, Character target) {
        int damage = 25;
        target.takeDamage(damage);
        System.out.println(user.getName() + " menggunakan Slash pada " + target.getName() + " sebesar " + damage + " damage!");
    }

    @Override
    public int getManaCost() {
        return 20;
    }
}