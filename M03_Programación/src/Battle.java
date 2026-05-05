import java.util.ArrayList;
import java.util.Random;

public class Battle {

    private ArrayList<MilitaryUnit>[] civilizationArmy;
    private ArrayList<MilitaryUnit>[] enemyArmy;
    private String battleDevelopment;
    private Random random;

    public Battle(ArrayList<MilitaryUnit>[] civilizationArmy, ArrayList<MilitaryUnit>[] enemyArmy) {
        this.civilizationArmy = civilizationArmy;
        this.enemyArmy = enemyArmy;
        this.battleDevelopment = "";
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
    }

    private void attack(ArrayList<MilitaryUnit>[] attackerArmy,
                        ArrayList<MilitaryUnit>[] defenderArmy,
                        String attackerName,
                        String defenderName) {

        MilitaryUnit attacker = getRandomUnit(attackerArmy);
        MilitaryUnit defender = getRandomUnit(defenderArmy);

        if (attacker == null || defender == null) {
            return;
        }

        int damage = attacker.attack();
        defender.takeDamage(damage);

        battleDevelopment += attackerName + " attacks " + defenderName + "\n";
        battleDevelopment += "Damage: " + damage + "\n";
        battleDevelopment += "Defender armor: " + defender.getActualArmor() + "\n";

        if (defender.getActualArmor() <= 0) {
            removeDeadUnit(defenderArmy, defender);
            battleDevelopment += "A unit has been eliminated.\n";
        }

        battleDevelopment += "--------------------------\n";
    }

    private MilitaryUnit getRandomUnit(ArrayList<MilitaryUnit>[] army) {
        ArrayList<MilitaryUnit> allUnits = new ArrayList<>();

        for (ArrayList<MilitaryUnit> group : army) {
            allUnits.addAll(group);
        }

        if (allUnits.isEmpty()) {
            return null;
        }

        return allUnits.get(random.nextInt(allUnits.size()));
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