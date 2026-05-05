public class Cannon extends AttackUnit {

    public Cannon() {
        super(8000, 700);
    }

    public int getFoodCost() {
        return 0;
    }

    public int getWoodCost() {
        return 30000;
    }

    public int getIronCost() {
        return 15000;
    }

    public int getManaCost() {
        return 0;
    }
}