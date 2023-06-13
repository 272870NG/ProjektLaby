package org.example;

public class Bandit implements GameObject{
    private int unitAttackPower;
    private int healthPoints;
    public Bandit (){
        this.healthPoints = 150;
        this.unitAttackPower = 50;
    }

    @Override
    public void takeDamage(int attackPower) {healthPoints -= attackPower;}

    @Override
    public int attack() {return unitAttackPower;}

    @Override
    public int getHealth() {return healthPoints;}

    @Override
    public void getWeapon() {unitAttackPower *= 3;}

    @Override
    public void getSteroids() {healthPoints *= 5;}
}
