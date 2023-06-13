package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PlayerMove implements GameAction{

    @Override
    public Map<GameObject, Country> applyAction(Map<GameObject, Country> currentState, List<Country> europe) {
        GameObject player = currentState.keySet()
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElseThrow();
        Country currentPlayerCountry = currentState.get(player);


        //wybierz kolejny kraj (dodać do innej klasy)
        // int countryOfChoice = new UserPrompter().askForNextCountry(currentPlayerCountry,europe);

        int currentPlayerCountryIndex = europe.indexOf(currentPlayerCountry) + 1;
        // stworz nowy stan w oparciu o stary
        HashMap<GameObject,Country> newState = new HashMap<>(currentState);
        // umiesc gracza
        newState.put(player, europe.get(currentPlayerCountryIndex));
        // zwroc stan
        return newState;
    }
}
