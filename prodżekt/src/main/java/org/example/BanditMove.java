package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BanditMove implements  GameAction{
    @Override
    public Map<GameObject, Country> applyAction(Map<GameObject, Country> currentState, List<Country> europe) {
        GameObjectFinder finder = new GameObjectFinder();

        GameObject bandit = finder.findBandit(currentState);
        if(bandit == null){return currentState;}

        int currentBanditCountryIndex = FixedGameState.getRandomCountryIndex();;
        HashMap<GameObject,Country> newState = new HashMap<>(currentState);
        newState.put(bandit, europe.get(currentBanditCountryIndex));
        return newState;
    }
}
