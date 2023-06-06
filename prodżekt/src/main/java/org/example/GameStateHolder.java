package org.example;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class GameStateHolder {
    private static List<GameRule> RULES_TO_APPLY_EACH_ACTION = List.of(
        new PlayerEncountersBandit()
    );

    private final List<Country> europe;

    private Map<GameObject, Country> gameMap;

    private final Country destination;


    public GameStateHolder(List<Country> europe, Map<GameObject, Country> gameMap,Country destination) {
        this.europe = europe;
        this.gameMap = gameMap;
        this.destination = destination;
    }

    public void applyGameAction(GameAction gameAction) {
        gameMap = gameAction.applyAction(gameMap, europe);

        for (GameRule rule: RULES_TO_APPLY_EACH_ACTION) {
            this.gameMap = rule.applyRule(this.gameMap, europe);
        }
    }

    public boolean playerIsAlive() {
        try {
            GameObject player = gameMap.keySet()
                    .stream()
                    .filter(gameObject -> gameObject instanceof Player)
                    .findFirst()
                    .orElseThrow();
            return true;
        } catch(Exception NoSuchElementException){return false;}
    }

    public boolean playerHasReachedDestination() {
        return destination.equals(findPlayerCountry());
    }

    public String getDestinationName(){return destination.getName();}

    Country findPlayerCountry() {
        try {
            GameObject player = gameMap.keySet()
                    .stream()
                    .filter(it -> it instanceof Player)
                    .findFirst()
                    .orElseThrow();

            return gameMap.get(player);
        }
        catch(Exception NoSuchElementException){return null;}
    }


    @Override
    public String toString() {
        return "GameStateHolder{" +
                "europe=" + europe +
                ", gameMap=" + gameMap +
                '}';
    }

}
