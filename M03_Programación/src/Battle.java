import java.util.ArrayList;
import java.util.Random;

public class Battle {

    private ArrayList<MilitaryUnit>[] civilizationArmy;
    private ArrayList<MilitaryUnit>[] enemyArmy;
    private String battleDevelopment;
    private int wasteWood;
    private int wasteIron;
    private Random random;

    public Battle(ArrayList<MilitaryUnit>[] civilizationArmy, ArrayList<MilitaryUnit>[] enemyArmy) {
        this.civilizationArmy = civilizationArmy;
        this.enemyArmy = enemyArmy;
        this.battleDevelopment = "";
        this.wasteWood = 0;
        this.wasteIron = 0;
        this.random = new Random();
    }

    public void startBattle() {
        battleDevelopment += "===== BATTLE STARTED =====\n";

        boolean civilizationTurn = random.nextBoolean();

        while (getTotalUnits(civilizationArmy) > 0 && getTotalUnits(enemyArmy) > 0) {
            if (civilizationTurn) {
                attack(civilizationArmy, enemyArmy, "Civilization", "Enemy");
            } else {
                attack(enemyArmy, civilizationArmy, "Enemy", "Civilization");
            }

            civilizationTurn = !civilizationTurn;
        }

        battleDevelopment += "===== BATTLE FINISHED =====\n";

        if (getTotalUnits(civilizationArmy) > 0) {
            battleDevelopment += "Winner: Civilization\n";
        } else {
            battleDevelopment += "Winner: Enemy\n";
        }

        battleDevelopment += "Waste generated wood: " + wasteWood + "\n";
        battleDevelopment += "Waste generated iron: " + wasteIron + "\n";
    }

    private void attack(ArrayList<MilitaryUnit>[] attackerArmy,
                        ArrayList<MilitaryUnit>[] defenderArmy,
                        String attackerName,
                        String defenderName) {

        MilitaryUnit attacker = getRandomUnitByGroup(attackerArmy);
        MilitaryUnit defender = getRandomUnitByGroup(defenderArmy);

        if (attacker == null || defender == null) {
            return;
        }

        int damage = attacker.attack();
        defender.takeDamage(damage);

        battleDevelopment += attackerName + " attacks " + defenderName + "\n";
        battleDevelopment += "Damage: " + damage + "\n";
        battleDevelopment += "Defender armor: " + defender.getActualArmor() + "\n";

        if (defender.getActualArmor() <= 0) {
            wasteWood += defender.getWoodCost() * 70 / 100;
            wasteIron += defender.getIronCost() * 70 / 100;
            removeDeadUnit(defenderArmy, defender);
            battleDevelopment += "Unit eliminated.\n";
        }

        battleDevelopment += "----------------------\n";
    }

    private MilitaryUnit getRandomUnitByGroup(ArrayList<MilitaryUnit>[] army) {
        int total = getTotalUnits(army);

        if (total == 0) {
            return null;
        }

        int randomNumber = random.nextInt(total) + 1;
        int sum = 0;

        for (ArrayList<MilitaryUnit> group : army) {
            sum += group.size();

            if (randomNumber <= sum && !group.isEmpty()) {
                return group.get(random.nextInt(group.size()));
            }
        }

        return null;
    }

    private void removeDeadUnit(ArrayList<MilitaryUnit>[] army, MilitaryUnit unit) {
        for (ArrayList<MilitaryUnit> group : army) {
            if (group.remove(unit)) {
                return;
            }
        }
    }

    private int getTotalUnits(ArrayList<MilitaryUnit>[] army) {
        int total = 0;

        for (ArrayList<MilitaryUnit> group : army) {
            total += group.size();
        }

        return total;
    }

    public String getBattleDevelopment() {
        return battleDevelopment;
    }
}