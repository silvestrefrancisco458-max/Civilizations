package fighters.mystic;

import fighters.CombatUnit;

public abstract class MysticUnit implements CombatUnit {

    protected int armor;
    protected int damage;

    public int attack() {
        return damage;
    }

    public void receiveDamage(int damage) {
        armor -= damage;
    }

    public int getArmor() {
        return armor;
    }

}
