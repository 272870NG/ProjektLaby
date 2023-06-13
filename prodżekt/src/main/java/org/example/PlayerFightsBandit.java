package org.example;

import java.util.List;
import java.util.Map;

public class PlayerFightsBandit implements GameAction{
    @Override
    public Map<GameObject, Country> applyAction(Map<GameObject, Country> currentState, List<Country> europe) {

        GameObject player = currentState.keySet()
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElseThrow();

        GameObject bandit;
        try {
            bandit = currentState.keySet()
                    .stream()
                    .filter(gameObject -> gameObject instanceof Bandit)
                    .findFirst()
                    .orElseThrow();
        }
        catch(Exception NoSuchEllementException){return currentState;}

        do{
            if (Math.round(Math.random()) == 1){
                bandit.takeDamage(player.attack());
            }else{
                player.takeDamage(bandit.attack());
            }
        }while(player.getHealth() > 0 && bandit.getHealth() > 0);
        if(player.getHealth() == 0){currentState.remove(player);}
        else {
            System.out.println("You survived");
            System.out.println("------------");
            currentState.remove(bandit);}
        return currentState;
    }
}
