public class Crossbow extends AttackUnit {

    public Crossbow() {
        super(6000, 1000);
    }

    public int getFoodCost() {
        return 0;
    }

    public int getWoodCost() {
        return 45000;
    }

    public int getIronCost() {
        return 7000;
    }

    public int getManaCost() {
        return 0;
    }
}