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

        int currentBanditCountryIndex = (int)Math.round(Math.random() * 15);;
        // stworz nowy stan w oparciu o stary
        HashMap<GameObject,Country> newState = new HashMap<>(currentState);
        // umiesc bandyte
        newState.put(bandit, europe.get(currentBanditCountryIndex));
        // zwroc stan
        return newState;
    }
}
