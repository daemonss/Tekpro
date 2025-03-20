package battle;

import characters.Character;
import skills.Skill;
import items.Item;

import java.util.ArrayList;
import java.util.List;

public class BattleSystem {
    private Character player1;
    private Character player2;

    public BattleSystem(Character player1, Character player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startBattle() {
        System.out.println("Battle started between " + player1.getName() + " (Level " + player1.getLevel() + ") and " + player2.getName() + " (Level " + player2.getLevel() + ")!");

        // Urutan giliran berdasarkan speed
        List<Character> turnOrder = new ArrayList<>();
        turnOrder.add(player1);
        turnOrder.add(player2);
        turnOrder.sort((c1, c2) -> c2.getSpeed() - c1.getSpeed()); // Urutkan dari speed tertinggi ke terendah

        while (player1.isAlive() && player2.isAlive()) {
            for (Character currentPlayer : turnOrder) {
                if (currentPlayer.isAlive()) {
                    System.out.println("\n--- " + currentPlayer.getName() + "'s Turn ---");
                    performTurn(currentPlayer, currentPlayer == player1 ? player2 : player1);
                }
            }
        }

        System.out.println("\nBattle ended!");
        if (player1.isAlive()) {
            player1.gainExperience(50);
            System.out.println(player1.getName() + " menang dan mendapatkan 50 XP!");
        } else {
            player2.gainExperience(50);
            System.out.println(player2.getName() + " menang dan mendapatkan 50 XP!");
        }
    }

    private void performTurn(Character currentPlayer, Character opponent) {
        // Handle status effect sebelum giliran
        currentPlayer.handleStatusEffect();

        // Jika karakter masih hidup setelah status effect
        if (currentPlayer.isAlive()) {
            if (!currentPlayer.getSkills().isEmpty()) {
                Skill skill = currentPlayer.getSkills().get(0); // Gunakan skill pertama
                currentPlayer.useSkill(skill, opponent);
            } else if (!currentPlayer.getItems().isEmpty()) {
                Item item = currentPlayer.getItems().get(0); // Gunakan item pertama
                currentPlayer.useItem(item);
            } else {
                currentPlayer.attack(opponent); // Serangan dasar
            }
        }
    }
}