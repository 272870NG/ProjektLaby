package org.example;

import java.util.List;
import java.util.Map;

public class PlayerFightsBandit implements GameAction{
    @Override
    public Map<GameObject, Country> applyAction(Map<GameObject, Country> currentState, List<Country> europe) {

        GameObjectFinder finder = new GameObjectFinder();

        GameObject player = finder.findPlayer(currentState);

        GameObject bandit = finder.findBandit(currentState);

        do{
            if (Math.round(Math.random()) == 1){
                bandit.takeDamage(player.attack());
            }else{
                player.takeDamage(bandit.attack());
            }
        }while(player.getHealth() > 0 && bandit.getHealth() > 0);
        if(player.getHealth() <= 0){currentState.remove(player);}
        else {
            System.out.println("You survived");
            System.out.println("------------");
            currentState.remove(bandit);}
        return currentState;
    }
}
