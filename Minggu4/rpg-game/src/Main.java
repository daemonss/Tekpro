import characters.Character;
import characters.Warrior;
import characters.Mage;
import skills.Fireball;
import skills.Slash;
import items.HealthPotion;
import items.ManaPotion;
import battle.BattleSystem;

public class Main {
    public static void main(String[] args) {
        Character warrior = new Warrior("Daemon");
        Character mage = new Mage("Hyungsik");

        warrior.addSkill(new Slash());
        mage.addSkill(new Fireball());

        warrior.addItem(new HealthPotion());
        mage.addItem(new ManaPotion());

        System.out.println("Warrior: " + warrior.getName() + " (HP: " + warrior.getHealth() + ", Mana: " + warrior.getMana() + ")");
        System.out.println("Mage: " + mage.getName() + " (HP: " + mage.getHealth() + ", Mana: " + mage.getMana() + ")");

        BattleSystem battle = new BattleSystem(warrior, mage);
        battle.startBattle();
    }
}