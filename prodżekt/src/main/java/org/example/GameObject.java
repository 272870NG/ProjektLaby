package org.example;

public interface GameObject {
    void takeDamage(int enemyAttackPower);
    int attack();
    int getHealth();
}
