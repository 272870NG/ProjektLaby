package org.example;

public class Player implements GameObject{
    private int unitAttackPower;
    private int healthPoints;
    public Player (){
        this.healthPoints = 200;
        this.unitAttackPower = 50;
    }
    @Override
    public void takeDamage(int attackPower){healthPoints -= attackPower;}
    @Override
    public int attack(){return unitAttackPower;}
    @Override
    public int getHealth(){return healthPoints;}
    @Override
    public void getWeapon(){unitAttackPower *= 3;}
    @Override
    public void getSteroids(){healthPoints *= 5;}
}
