package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MerchantMove implements GameAction{
    @Override
    public Map<GameObject, Country> applyAction(Map<GameObject, Country> currentState, List<Country> europe) {
        GameObjectFinder finder = new GameObjectFinder();

        GameObject merchant = finder.findMerchant(currentState);

        int currentMerchantCountryIndex = FixedGameState.getRandomCountryIndex();;
        HashMap<GameObject,Country> newState = new HashMap<>(currentState);
        newState.put(merchant, europe.get(currentMerchantCountryIndex));
        return newState;
    }
}
