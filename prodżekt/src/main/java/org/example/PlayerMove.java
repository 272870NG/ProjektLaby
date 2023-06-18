package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PlayerMove implements GameAction{

    @Override
    public Map<GameObject, Country> applyAction(Map<GameObject, Country> currentState, List<Country> europe) {

        GameObjectFinder finder = new GameObjectFinder();

        GameObject player = finder.findPlayer(currentState);
        Country currentPlayerCountry = currentState.get(player);

        int countryOfChoice = new UserPrompter().askForNextCountry(currentPlayerCountry,europe);

        // int currentPlayerCountryIndex = europe.indexOf(currentPlayerCountry) + 1;
        HashMap<GameObject,Country> newState = new HashMap<>(currentState);
        newState.put(player, europe.get(countryOfChoice));
        return newState;
    }
}
