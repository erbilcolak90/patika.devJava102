package Inventory;

import weapon.Armor;
import weapon.Weapon;

public class Inventory {
    private Armor armor;

    private Weapon weapon;
    boolean water;
    boolean firewood;
    boolean food;


    public Inventory() {

        this.armor = new Armor(0, "Normal", 0, 0);
        this.weapon = new Weapon("punch",0,0,0);
        this.water = false;
        this.firewood = false;
        this.food = false;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }
}
