package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


class PlayerMoveToNextRoom implements GameAction{

    @Override
    public Map<GameObject, Country> applyAction(Map<GameObject, Country> currentState, List<Country> hallway) {
        GameObject player = currentState.keySet()
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElseThrow();
        Country currentPlayerRoom = currentState.get(player);


        //znajdz kolejny pokoj
        int currentPlayerRoomIndex = hallway.indexOf(currentPlayerRoom) + 1;
        // stworz nowy stan w oparciu o stary
        HashMap<GameObject,Country> newState = new HashMap<>(currentState);
        // umiesc gracza
        newState.put(player, hallway.get(currentPlayerRoomIndex));
        // zwroc stan
        return newState;
    }
}