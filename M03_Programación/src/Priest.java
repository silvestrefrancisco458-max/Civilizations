public class Priest extends AttackUnit {

    public Priest() {
        super(1500, 0);
    }

    public int getFoodCost() {
        return 0;
    }

    public int getWoodCost() {
        return 1000;
    }

    public int getIronCost() {
        return 0;
    }

    public int getManaCost() {
        return 200;
    }
}