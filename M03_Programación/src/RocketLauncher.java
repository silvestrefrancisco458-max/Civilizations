public class RocketLauncher extends DefenseUnit {

    public RocketLauncher() {
        super(7000, 2000);
    }

    public int getFoodCost() {
        return 0;
    }

    public int getWoodCost() {
        return 50000;
    }

    public int getIronCost() {
        return 5000;
    }

    public int getManaCost() {
        return 0;
    }
}