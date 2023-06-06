package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PlayerEncountersBandit implements GameRule {
    @Override
    public Map<GameObject, Country> applyRule(Map<GameObject, Country> currentState, List<Country> hallway) {
        System.out.println("Player fights bandit?");
        System.out.println("---------------------");
        // Znajdz gracza
        GameObject player = currentState.keySet()
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElseThrow();
        Country currentPlayerCountry = currentState.get(player);
        // Znajdz bandyte
        Country currentbanditCountry;
        GameObject bandit;
        try {
            bandit = currentState.keySet()
                    .stream()
                    .filter(gameObject -> gameObject instanceof Bandit)
                    .findFirst()
                    .orElseThrow();
            currentbanditCountry = currentState.get(bandit);
        }
        catch(Exception NoSuchEllementException){return currentState;}




        if (currentbanditCountry.equals(currentPlayerCountry)) {
            System.out.println("Player fights bandit");
            System.out.println("--------------------");
            if (Math.round(Math.random()) == 1) {
                HashMap<GameObject, Country> newState = new HashMap<>(currentState);
                newState.remove(bandit);
                System.out.println("Player won");
                System.out.println("----------");
                return newState;
            } else {
                HashMap<GameObject, Country> newState = new HashMap<>(currentState);
                newState.remove(player);
                System.out.println("Player lost");
                System.out.println("-----------");
                return newState;
            }
        }
        return currentState;
    }
}
