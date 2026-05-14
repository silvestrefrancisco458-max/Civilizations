package core;

public class Empire {

    private int food = 10000;
    private int wood = 10000;
    private int iron = 10000;
    private int mana = 5000;

    private int farms = 0;
    private int carpentries = 0;
    private int smithies = 0;
    private int magicTowers = 0;
    private int churches = 0;

    private int swordsmen = 0;
    private int spearmen = 0;
    private int crossbows = 0;
    private int cannons = 0;
    private int arrowTowers = 0;
    private int catapults = 0;
    private int rocketTowers = 0;
    private int magicians = 0;
    private int priests = 0;

    public int getFood() { return food; }
    public int getWood() { return wood; }
    public int getIron() { return iron; }
    public int getMana() { return mana; }

    public int getFarms() { return farms; }
    public int getCarpentries() { return carpentries; }
    public int getSmithies() { return smithies; }
    public int getMagicTowers() { return magicTowers; }
    public int getChurches() { return churches; }

    public int getSwordsmen() { return swordsmen; }
    public int getSpearmen() { return spearmen; }
    public int getCrossbows() { return crossbows; }
    public int getCannons() { return cannons; }
    public int getArrowTowers() { return arrowTowers; }
    public int getCatapults() { return catapults; }
    public int getRocketTowers() { return rocketTowers; }
    public int getMagicians() { return magicians; }
    public int getPriests() { return priests; }

    private boolean pay(int foodCost, int woodCost, int ironCost, int manaCost) {
        if (food < foodCost || wood < woodCost || iron < ironCost || mana < manaCost) {
            return false;
        }

        food -= foodCost;
        wood -= woodCost;
        iron -= ironCost;
        mana -= manaCost;
        return true;
    }

    public boolean buildFarm() {
        if (pay(5000, 1000, 0, 0)) {
            farms++;
            return true;
        }
        return false;
    }

    public boolean buildCarpentry() {
        if (pay(2000, 3000, 0, 0)) {
            carpentries++;
            return true;
        }
        return false;
    }

    public boolean buildSmithy() {
        if (pay(2000, 2000, 3000, 0)) {
            smithies++;
            return true;
        }
        return false;
    }

    public boolean buildMagicTower() {
        if (pay(3000, 4000, 2000, 0)) {
            magicTowers++;
            return true;
        }
        return false;
    }

    public boolean buildChurch() {
        if (pay(3000, 3000, 1000, 0)) {
            churches++;
            return true;
        }
        return false;
    }

    public boolean createSwordsman() {
        if (pay(800, 300, 50, 0)) {
            swordsmen++;
            return true;
        }
        return false;
    }

    public boolean createSpearman() {
        if (pay(500, 650, 50, 0)) {
            spearmen++;
            return true;
        }
        return false;
    }

    public boolean createCrossbow() {
        if (pay(0, 1000, 700, 0)) {
            crossbows++;
            return true;
        }
        return false;
    }

    public boolean createCannon() {
        if (pay(0, 2000, 1500, 0)) {
            cannons++;
            return true;
        }
        return false;
    }

    public boolean createArrowTower() {
        if (pay(0, 1000, 0, 0)) {
            arrowTowers++;
            return true;
        }
        return false;
    }

    public boolean createCatapult() {
        if (pay(0, 1500, 500, 0)) {
            catapults++;
            return true;
        }
        return false;
    }

    public boolean createRocketTower() {
        if (pay(0, 3000, 3000, 0)) {
            rocketTowers++;
            return true;
        }
        return false;
    }

    public boolean createMagician() {
        if (magicTowers <= 0) {
            return false;
        }

        if (pay(1200, 200, 50, 1000)) {
            magicians++;
            return true;
        }

        return false;
    }

    public boolean createPriest() {
        if (churches <= priests) {
            return false;
        }

        if (pay(1500, 0, 0, 1000)) {
            priests++;
            return true;
        }

        return false;
    }

    public void addResources() {
        food += 100 + farms * 50;
        wood += 80 + carpentries * 40;
        iron += 60 + smithies * 30;
        mana += magicTowers * 30;
    }

    public void generateResources() {
        addResources();
    }

    public int getTotalUnits() {
        return swordsmen + spearmen + crossbows + cannons
                + arrowTowers + catapults + rocketTowers
                + magicians + priests;
    }

    public int getTotalAttack() {
        return swordsmen * 80
                + spearmen * 150
                + crossbows * 1000
                + cannons * 700
                + arrowTowers * 80
                + catapults * 250
                + rocketTowers * 2000
                + magicians * 3000;
    }

    public int getTotalDefense() {
        return swordsmen * 400
                + spearmen * 1000
                + crossbows * 6000
                + cannons * 8000
                + arrowTowers * 200
                + catapults * 1200
                + rocketTowers * 7000;
    }

    public void addBattleReward(int woodReward, int ironReward) {
        wood += woodReward;
        iron += ironReward;
    }

    public void loseUnitsAfterBattle() {
        if (swordsmen > 0) swordsmen--;
        if (spearmen > 0) spearmen--;
        if (crossbows > 0) crossbows--;
        if (cannons > 0) cannons--;
        if (arrowTowers > 0) arrowTowers--;
        if (catapults > 0) catapults--;
        if (rocketTowers > 0) rocketTowers--;
        if (magicians > 0) magicians--;
        if (priests > 0) priests--;
    }
}