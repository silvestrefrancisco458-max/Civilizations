import java.util.ArrayList;

public class Civilization {

    private int food;
    private int wood;
    private int iron;
    private int mana;

    private int farm;
    private int smithy;
    private int carpentry;
    private int magicTower;
    private int church;

    private ArrayList<MilitaryUnit> army;

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

        army = new ArrayList<>();
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

                army.add(swordsman);
                created++;
            } else {
                break;
            }
        }

        System.out.println("Espadachines creados: " + created);
    }

    public void printStats() {
        System.out.println("===== CIVILIZATION STATS =====");
        System.out.println("Food: " + food);
        System.out.println("Wood: " + wood);
        System.out.println("Iron: " + iron);
        System.out.println("Mana: " + mana);

        System.out.println("Farm: " + farm);
        System.out.println("Smithy: " + smithy);
        System.out.println("Carpentry: " + carpentry);
        System.out.println("Magic Tower: " + magicTower);
        System.out.println("Church: " + church);

        System.out.println("Army units: " + army.size());
    }
}