package org.example;

public class Merchant implements GameObject{
    private int unitAttackPower;
    private int healthPoints;
    public Merchant (){
        this.healthPoints = 50;
        this.unitAttackPower = 0;
    }
    @Override
    public void takeDamage(int enemyAttackPower) {healthPoints -= enemyAttackPower;}

    @Override
    public int attack() {
        return unitAttackPower;
    }

    @Override
    public int getHealth() {
        return healthPoints;
    }

    @Override
    public void getWeapon() {}

    @Override
    public void getSteroids() {
    }
}
