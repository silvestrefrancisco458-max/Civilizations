public class Magician extends AttackUnit {

    public Magician() {
        super(3000, 500);
    }

    public int getFoodCost() {
        return 0;
    }

    public int getWoodCost() {
        return 2000;
    }

    public int getIronCost() {
        return 0;
    }

    public int getManaCost() {
        return 300;
    }
}