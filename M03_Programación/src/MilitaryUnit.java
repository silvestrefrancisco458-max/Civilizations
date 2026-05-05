public interface MilitaryUnit {
    int attack();
    void takeDamage(int damage);
    int getActualArmor();

    int getFoodCost();
    int getWoodCost();
    int getIronCost();
    int getManaCost();

    void resetArmor();
}