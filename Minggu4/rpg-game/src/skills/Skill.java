package skills;

import characters.Character;

// Interface: Skill (Kontrak untuk semua skill)
public interface Skill {
    void activate(Character user, Character target); // Polymorphism: Bisa Fireball, Slash, dll.
    int getManaCost();
}