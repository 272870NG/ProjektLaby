package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PlayerEncountersBandit implements GameRule {
    @Override
    public Map<GameObject, Country> applyRule(Map<GameObject, Country> currentState, List<Country> europe) {
        System.out.println("Player fights bandit?");
        System.out.println("---------------------");
        // Znajdz gracza
        GameObjectFinder finder = new GameObjectFinder();

        GameObject player = finder.findPlayer(currentState);
        Country currentPlayerCountry = currentState.get(player);

        // Znajdz bandyte
        GameObject bandit = finder.findBandit(currentState);
        if(bandit == null){return currentState;}
        Country currentBanditCountry = currentState.get(bandit);





//        if (currentBanditCountry.equals(currentPlayerCountry)) {
//            System.out.println("Player fights bandit");
//            System.out.println("--------------------");
//            if (Math.round(Math.random()) == 1) {
//                HashMap<GameObject, Country> newState = new HashMap<>(currentState);
//                newState.remove(bandit);
//                System.out.println("Player lived");
//                System.out.println("----------");
//                return newState;
//            } else {
//                HashMap<GameObject, Country> newState = new HashMap<>(currentState);
//                newState.remove(player);
//                System.out.println("Player died");
//                System.out.println("-----------");
//                return newState;
//            }
//        }

        if (currentBanditCountry.equals(currentPlayerCountry)) {
            System.out.println("Player fights bandit");
            System.out.println("--------------------");
            return new PlayerFightsBandit().applyAction(currentState,europe);
        }
        return currentState;
    }
}
