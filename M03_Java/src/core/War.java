package core;

import java.util.Random;

public class War {

    private Empire empire;

    public War(Empire empire) {
        this.empire = empire;
    }

    public void startBattle() {

        Random random = new Random();

        int enemyAttack = random.nextInt(5000) + 1000;

        int defense = empire.getTotalDefense();

        if (defense >= enemyAttack) {

            int woodReward = random.nextInt(2000) + 500;
            int ironReward = random.nextInt(1000) + 200;

            empire.addBattleReward(woodReward, ironReward);

            System.out.println("Victoria en la batalla");

        } else {

            empire.loseUnitsAfterBattle();

            System.out.println("Derrota en la batalla");
        }
    }
}