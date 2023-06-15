package org.example;

public class Bandit implements GameObject{
    private static int unitAttackPower;
    private static int healthPoints;
    public Bandit (){
        healthPoints = 150;
        unitAttackPower = 50;
    }

    @Override
    public void takeDamage(int attackPower) {healthPoints -= attackPower;}

    @Override
    public int attack() {return unitAttackPower;}

    @Override
    public int getHealth() {return healthPoints;}


    public void getAttackUpgrade() {unitAttackPower *= 3;}


    public void getHealthUpgrade() {healthPoints *= 5;}
}
