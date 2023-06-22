package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PlayerEncountersBandit implements GameRule {
    @Override
    public Map<GameObject, Country> applyRule(Map<GameObject, Country> currentState, List<Country> europe) {
        GameObjectFinder finder = new GameObjectFinder();

        GameObject player = finder.findPlayer(currentState);
        Country currentPlayerCountry = currentState.get(player);

        GameObject bandit = finder.findBandit(currentState);
        if(bandit == null){return currentState;}
        Country currentBanditCountry = currentState.get(bandit);

        if (currentBanditCountry.equals(currentPlayerCountry)) {
            System.out.println("Player fights bandit");
            System.out.println("--------------------");
            return new PlayerFightsBandit().applyAction(currentState,europe);
        }
        return currentState;
    }
}
