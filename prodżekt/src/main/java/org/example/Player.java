package org.example;

public class Player implements GameObject{
    private static int unitAttackPower;
    private static int healthPoints;
    public Player (){
        healthPoints = 200;
        unitAttackPower = 50;
    }
    @Override
    public void takeDamage(int attackPower){healthPoints -= attackPower;}
    @Override
    public int attack(){return unitAttackPower;}
    @Override
    public int getHealth(){return healthPoints;}

    public void getAttackUpgrade() {unitAttackPower *= 3;}


    public void getHealthUpgrade() {healthPoints *= 5;}
}
