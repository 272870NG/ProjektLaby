package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerEncountersBandit implements GameRule {
    @Override
    public Map<GameObject, Country> applyRule(Map<GameObject, Country> currentState, List<Country> hallway) {
        System.out.println("Player fights bandit?");
        // Znajdz gracza
        GameObject player = currentState.keySet()
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElseThrow();
        Country currentPlayerCountry = currentState.get(player);
        // Znajdz bandyte
        GameObject bandit = currentState.keySet()
                .stream()
                .filter(gameObject -> gameObject instanceof Bandit)
                .findFirst()
                .orElseThrow();
        Country currentbanditCountry = currentState.get(bandit);

        if (currentbanditCountry.equals(currentPlayerCountry)) {
            System.out.println("Player fights bandit");
            if (Math.round(Math.random()) == 1) {
                HashMap<GameObject, Country> newState = new HashMap<>(currentState);
                newState.remove(bandit);
                System.out.println("Player won");
                return newState;
            } else {
                HashMap<GameObject, Country> newState = new HashMap<>(currentState);
                newState.remove(player);
                System.out.println("Player lost");
                return newState;
            }
        }
        return currentState;
    }
}
