public class Swordsman extends attackUnit {
    
    public Swordsman() {
        super(400, 80);
    }

    public int getFoodCost() {
        return 8000;
    }

    public int getWoodCost() {
        return 3000;
    }

    public int getIronCost() {
        return 50;
    }

    public int getManaCost() {
        return 0;
    }
}