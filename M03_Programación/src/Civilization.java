import java.util.ArrayList;

public class Civilization implements Variables {

    private int food;
    private int wood;
    private int iron;
    private int mana;

    private int farm;
    private int smithy;
    private int carpentry;
    private int magicTower;
    private int church;

    private int technologyDefense;
    private int technologyAttack;

    private ArrayList<MilitaryUnit>[] army;
    private ArrayList<MilitaryUnit>[] enemyArmy;

    public int getFood() { return food; }
    public int getWood() { return wood; }
    public int getIron() { return iron; }
    public int getMana() { return mana; }
    public int getFarm() { return farm; }
    public int getSmithy() { return smithy; }
    public int getCarpentry() { return carpentry; }
    public int getMagicTower() { return magicTower; }
    public int getChurch() { return church; }
    public int getTechnologyDefense() { return technologyDefense; }
    public int getTechnologyAttack() { return technologyAttack; }

    public Civilization() {
        food = 50000;
        wood = 50000;
        iron = 50000;
        mana = 0;

        farm = 0;
        smithy = 0;
        carpentry = 0;
        magicTower = 0;
        church = 0;
        technologyDefense = 0;
        technologyAttack = 0;

        army = new ArrayList[9];
        for (int i = 0; i < army.length; i++) {
            army[i] = new ArrayList<>();
        }

        enemyArmy = new ArrayList[9];
        for (int i = 0; i < enemyArmy.length; i++) {
            enemyArmy[i] = new ArrayList<>();
        }
    }

    public void newFarm() {
        if (food >= 5000 && wood >= 10000 && iron >= 12000) {
            food -= 5000;
            wood -= 10000;
            iron -= 12000;
            farm++;
            System.out.println("Granja creada correctamente.");
        } else {
            System.out.println("No tienes recursos suficientes.");
        }
    }

    public void newSmithy() {
        if (food >= 5000 && wood >= 10000 && iron >= 12000) {
            food -= 5000;
            wood -= 10000;
            iron -= 12000;
            smithy++;
            System.out.println("Herrería creada correctamente.");
        } else {
            System.out.println("No tienes recursos suficientes.");
        }
    }

    public void newCarpentry() {
        if (food >= 5000 && wood >= 10000 && iron >= 12000) {
            food -= 5000;
            wood -= 10000;
            iron -= 12000;
            carpentry++;
            System.out.println("Carpintería creada correctamente.");
        } else {
            System.out.println("No tienes recursos suficientes.");
        }
    }

    public void createEnemyArmy() {
        for (int i = 0; i < enemyArmy.length; i++) {
            enemyArmy[i].clear();
        }

        enemyArmy[0].add(new Swordsman());
        enemyArmy[0].add(new Swordsman());
        enemyArmy[1].add(new Spearman());
        enemyArmy[2].add(new Crossbow());
        enemyArmy[3].add(new Cannon());

        System.out.println("Ejército enemigo creado.");
    }

    public void viewThreat() {
        System.out.println("===== NEW THREAT COMING =====");
        System.out.println("Enemy Swordsman: " + enemyArmy[0].size());
        System.out.println("Enemy Spearman: " + enemyArmy[1].size());
        System.out.println("Enemy Crossbow: " + enemyArmy[2].size());
        System.out.println("Enemy Cannon: " + enemyArmy[3].size());
    }

    public void simulateBattle() {
        createEnemyArmy();
        viewThreat();

        Battle battle = new Battle(army, enemyArmy);
        battle.startBattle();

        System.out.println(battle.getBattleDevelopment());
    }

    public void newSwordsman(int n) {
        int created = 0;

        for (int i = 0; i < n; i++) {
            Swordsman swordsman = new Swordsman();

            if (food >= swordsman.getFoodCost()
                    && wood >= swordsman.getWoodCost()
                    && iron >= swordsman.getIronCost()) {

                food -= swordsman.getFoodCost();
                wood -= swordsman.getWoodCost();
                iron -= swordsman.getIronCost();

                army[0].add(swordsman);
                created++;
            } else {
                break;
            }
        }

        System.out.println("Espadachines creados: " + created);
    }

    public void newSpearman(int n) {
        int created = 0;

        for (int i = 0; i < n; i++) {
            Spearman spearman = new Spearman();

            if (food >= spearman.getFoodCost()
                    && wood >= spearman.getWoodCost()
                    && iron >= spearman.getIronCost()) {

                food -= spearman.getFoodCost();
                wood -= spearman.getWoodCost();
                iron -= spearman.getIronCost();

                army[1].add(spearman);
                created++;
            } else {
                break;
            }
        }

        System.out.println("Lanceros creados: " + created);
    }

    public void newMagicTower() {
        if (food >= 5000 && wood >= 10000 && iron >= 12000) {
            food -= 5000;
            wood -= 10000;
            iron -= 12000;
            magicTower++;
            System.out.println("Torre mágica creada correctamente.");
        } else {
            System.out.println("No tienes recursos suficientes.");
        }
    }

    public void newChurch() {
        if (food >= 5000 && wood >= 10000 && iron >= 12000) {
            food -= 5000;
            wood -= 10000;
            iron -= 12000;
            church++;
            System.out.println("Iglesia creada correctamente.");
        } else {
            System.out.println("No tienes recursos suficientes.");
        }
    }

    public void newCrossbow(int n) {
        int created = 0;

        for (int i = 0; i < n; i++) {
            Crossbow crossbow = new Crossbow();

            if (food >= crossbow.getFoodCost()
                    && wood >= crossbow.getWoodCost()
                    && iron >= crossbow.getIronCost()) {

                food -= crossbow.getFoodCost();
                wood -= crossbow.getWoodCost();
                iron -= crossbow.getIronCost();

                army[2].add(crossbow);
                created++;
            } else {
                break;
            }
        }

        System.out.println("Ballestas creadas: " + created);
    }

    public void newCannon(int n) {
        int created = 0;

        for (int i = 0; i < n; i++) {
            Cannon cannon = new Cannon();

            if (food >= cannon.getFoodCost()
                    && wood >= cannon.getWoodCost()
                    && iron >= cannon.getIronCost()) {

                food -= cannon.getFoodCost();
                wood -= cannon.getWoodCost();
                iron -= cannon.getIronCost();

                army[3].add(cannon);
                created++;
            } else {
                break;
            }
        }

        System.out.println("Cañones creados: " + created);
    }

    public void newArrowTower(int n) {
    int created = 0;

    for (int i = 0; i < n; i++) {
            ArrowTower arrowTower = new ArrowTower();

            if (wood >= arrowTower.getWoodCost() && iron >= arrowTower.getIronCost()) {
                wood -= arrowTower.getWoodCost();
                iron -= arrowTower.getIronCost();

                army[4].add(arrowTower);
                created++;
            } else {
                break;
            }
        }

        System.out.println("Torres de flechas creadas: " + created);
    }

    public void newCatapult(int n) {
        int created = 0;

        for (int i = 0; i < n; i++) {
            Catapult catapult = new Catapult();

            if (wood >= catapult.getWoodCost() && iron >= catapult.getIronCost()) {
                wood -= catapult.getWoodCost();
                iron -= catapult.getIronCost();

                army[5].add(catapult);
                created++;
            } else {
                break;
            }
        }

        System.out.println("Catapultas creadas: " + created);
    }

    public void newRocketLauncher(int n) {
        int created = 0;

        for (int i = 0; i < n; i++) {
            RocketLauncher rocketLauncher = new RocketLauncher();

            if (wood >= rocketLauncher.getWoodCost() && iron >= rocketLauncher.getIronCost()) {
                wood -= rocketLauncher.getWoodCost();
                iron -= rocketLauncher.getIronCost();

                army[6].add(rocketLauncher);
                created++;
            } else {
                break;
            }
        }

        System.out.println("Lanzacohetes creados: " + created);
    }

    public void newMagician(int n) {
    if (magicTower == 0) {
        System.out.println("Necesitas una Torre Mágica.");
        return;
    }

    int created = 0;

    for (int i = 0; i < n; i++) {
            Magician magician = new Magician();

            if (wood >= magician.getWoodCost()
                    && mana >= magician.getManaCost()) {

                wood -= magician.getWoodCost();
                mana -= magician.getManaCost();

                army[7].add(magician);
                created++;
            } else {
                break;
            }
        }

        System.out.println("Magos creados: " + created);
    }

    public void newPriest(int n) {
    if (church == 0) {
        System.out.println("Necesitas una Iglesia.");
        return;
    }

    int created = 0;

    for (int i = 0; i < n; i++) {
            Priest priest = new Priest();

            if (wood >= priest.getWoodCost()
                    && mana >= priest.getManaCost()) {

                wood -= priest.getWoodCost();
                mana -= priest.getManaCost();

                army[8].add(priest);
                created++;
            } else {
                break;
            }
        }

        System.out.println("Sacerdotes creados: " + created);
    }

    public ArrayList<MilitaryUnit>[] getArmy() {
        return army;
    }

    public void upgradeTechnologyDefense() {
        if (iron >= UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST) {
            iron -= UPGRADE_BASE_DEFENSE_TECHNOLOGY_IRON_COST;
            technologyDefense++;
            System.out.println("Tecnología de defensa mejorada.");
        } else {
            System.out.println("No tienes hierro suficiente.");
        }
    }

    public void upgradeTechnologyAttack() {
        if (iron >= UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST) {
            iron -= UPGRADE_BASE_ATTACK_TECHNOLOGY_IRON_COST;
            technologyAttack++;
            System.out.println("Tecnología de ataque mejorada.");
        } else {
            System.out.println("No tienes hierro suficiente.");
        }
    }

    public void generateResources() {
        food += CIVILIZATION_FOOD_GENERATED + (farm * CIVILIZATION_FOOD_GENERATED_PER_FARM);
        wood += CIVILIZATION_WOOD_GENERATED + (carpentry * CIVILIZATION_WOOD_GENERATED_PER_CARPENTRY);
        iron += CIVILIZATION_IRON_GENERATED + (smithy * CIVILIZATION_IRON_GENERATED_PER_SMITHY);
        mana += magicTower * CIVILIZATION_MANA_GENERATED_PER_MAGIC_TOWER;

        System.out.println("Recursos generados correctamente.");
    }

    public void printStats() {
        System.out.println("========== CIVILIZATION STATS ==========");

        System.out.println("----- TECHNOLOGY -----");
        System.out.println("Attack: " + technologyAttack);
        System.out.println("Defense: " + technologyDefense);

        System.out.println("----- RESOURCES -----");
        System.out.println("Food: " + food);
        System.out.println("Wood: " + wood);
        System.out.println("Iron: " + iron);
        System.out.println("Mana: " + mana);

        System.out.println("----- BUILDINGS -----");
        System.out.println("Farm: " + farm);
        System.out.println("Smithy: " + smithy);
        System.out.println("Carpentry: " + carpentry);
        System.out.println("Magic Tower: " + magicTower);
        System.out.println("Church: " + church);

        System.out.println("----- ATTACK UNITS -----");
        System.out.println("Swordsman: " + army[0].size());
        System.out.println("Spearman: " + army[1].size());
        System.out.println("Crossbow: " + army[2].size());
        System.out.println("Cannon: " + army[3].size());

        System.out.println("----- DEFENSE UNITS -----");
        System.out.println("Arrow Tower: " + army[4].size());
        System.out.println("Catapult: " + army[5].size());
        System.out.println("Rocket Launcher: " + army[6].size());

        System.out.println("----- SPECIAL UNITS -----");
        System.out.println("Magician: " + army[7].size());
        System.out.println("Priest: " + army[8].size());
    }
}