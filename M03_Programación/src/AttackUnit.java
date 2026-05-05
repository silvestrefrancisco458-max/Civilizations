public abstract class AttackUnit implements MilitaryUnit {

    protected int armor;
    protected int initialArmor;
    protected int baseDamage;

    public AttackUnit(int armor, int baseDamage) {
        this.armor = armor;
        this.initialArmor = armor;
        this.baseDamage = baseDamage;
    }

    public int attack() {
        return baseDamage;
    }

    public void takeDamage(int damage) {
        armor -= damage;
    }

    public int getActualArmor() {
        return armor;
    }

    public void resetArmor() {
        armor = initialArmor;
    }
}