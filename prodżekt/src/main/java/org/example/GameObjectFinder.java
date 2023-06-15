package org.example;

import java.util.Map;

public class GameObjectFinder {
    public GameObject findPlayer(Map<GameObject, Country> currentState){
        return currentState.keySet()
            .stream()
            .filter(gameObject -> gameObject instanceof Player)
            .findFirst()
            .orElseThrow();}
    public GameObject findBandit(Map<GameObject, Country> currentState){
        try {
            return currentState.keySet()
                    .stream()
                    .filter(gameObject -> gameObject instanceof Bandit)
                    .findFirst()
                    .orElseThrow();
        } catch(Exception NoSuchEllementException){return null;}
    }
    public GameObject findMerchant(Map<GameObject, Country> currentState){
        return currentState.keySet()
                .stream()
                .filter(gameObject -> gameObject instanceof Merchant)
                .findFirst()
                .orElseThrow();

    }
}
