package characters;

import items.Item;
import skills.Skill;
import java.util.ArrayList;
import java.util.List;

// Abstract Class: Character (Kelas abstrak untuk semua karakter)
public abstract class Character {
    protected String name;
    protected int health;
    protected int maxHealth;
    protected int mana;
    protected int maxMana;
    protected int level;
    protected int experience;
    protected int speed;
    protected List<Skill> skills; // Polymorphism: Skill bisa berupa Fireball, Slash, dll.
    protected List<Item> items;   // Polymorphism: Item bisa berupa HealthPotion, ManaPotion, dll.
    protected StatusEffect statusEffect;

    // Constructor
    public Character(String name, int health, int mana, int speed) {
        this.name = name;
        this.maxHealth = health;
        this.health = health;
        this.maxMana = mana;
        this.mana = mana;
        this.level = 1;
        this.experience = 0;
        this.speed = speed;
        this.skills = new ArrayList<>();
        this.items = new ArrayList<>();
        this.statusEffect = null;
    }

    // Metode untuk menerima damage
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
        System.out.println(name + " menerima " + damage + " damage! HP: " + this.health);
    }

    // Metode untuk menambah XP
    public void gainExperience(int xp) {
        this.experience += xp;
        System.out.println(name + " mendapatkan " + xp + " XP!");
        if (this.experience >= 100 * this.level) {
            this.levelUp();
        }
    }

    // Metode untuk naik level
    private void levelUp() {
        this.level++;
        this.maxHealth += 20;
        this.maxMana += 10;
        this.health = this.maxHealth;
        this.mana = this.maxMana;
        System.out.println(name + " naik ke level " + level + "!");
    }

    // Metode untuk menangani status effect
    public void handleStatusEffect() {
        if (statusEffect != null) {
            switch (statusEffect) {
                case POISON:
                    this.health -= 5;
                    System.out.println(name + " kehilangan 5 HP karena poison!");
                    break;
                case BURN:
                    this.health -= 10;
                    System.out.println(name + " kehilangan 10 HP karena burn!");
                    break;
                case FREEZE:
                    System.out.println(name + " tidak bisa bergerak karena freeze!");
                    break;
            }
        }
    }

    // Metode untuk menggunakan skill
    public void useSkill(Skill skill, Character target) {
        if (this.mana >= skill.getManaCost()) {
            this.mana -= skill.getManaCost();
            skill.activate(this, target);
        } else {
            System.out.println(name + " tidak memiliki cukup mana untuk menggunakan " + skill.getClass().getSimpleName() + "!");
        }
    }

    // Metode untuk menggunakan item
    public void useItem(Item item) {
        item.use(this);
        items.remove(item); // Hapus item setelah digunakan
    }

    // Metode untuk menyerang (serangan dasar)
    public void attack(Character target) {
        int damage = 10; // Damage default
        target.takeDamage(damage);
        System.out.println(name + " menyerang " + target.getName() + " sebesar " + damage + " damage!");
    }

    // Getter & Setter
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getMana() { return mana; }
    public int getLevel() { return level; }
    public int getSpeed() { return speed; }
    public List<Skill> getSkills() { return skills; }
    public List<Item> getItems() { return items; }
    public void setHealth(int health) { this.health = Math.min(health, maxHealth); }
    public void setMana(int mana) { this.mana = mana; }
    public void addSkill(Skill skill) { skills.add(skill); }
    public void addItem(Item item) { items.add(item); }
    public void applyStatusEffect(StatusEffect effect) {
        this.statusEffect = effect;
        System.out.println(name + " terkena " + effect + "!");
    }
    public boolean isAlive() { return this.health > 0; }
}

