package org.example;

import java.util.List;
import java.util.Map;

public class GameStateHolder {
    private static List<GameRule> RULES_TO_APPLY_EACH_ACTION = List.of(
        new PlayerEncountersBandit()
    );

    private final List<Country> europe;

    private Map<GameObject, Country> gameMap;


    public GameStateHolder(List<Country> europe, Map<GameObject, Country> gameMap) {
        this.europe = europe;
        this.gameMap = gameMap;
    }

    public void applyGameAction(GameAction gameAction) {
        gameMap = gameAction.applyAction(gameMap, europe);

        for (GameRule rule: RULES_TO_APPLY_EACH_ACTION) {
            this.gameMap = rule.applyRule(this.gameMap, europe);
        }
    }

    public boolean playerIsAlive() {
        return true;
    }

    public boolean playerHarReachedFinalRoom() {
        Country lastRoom = europe.get(europe.size() - 1);

        return lastRoom.equals(findPlayerCountry());
    }


    Country findPlayerCountry() {
        GameObject player = gameMap.keySet()
                .stream()
                .filter(it -> it instanceof Player)
                .findFirst()
                .orElseThrow();

        return gameMap.get(player);
    }


    @Override
    public String toString() {
        return "GameStateHolder{" +
                "hallway=" + europe +
                ", gameMap=" + gameMap +
                '}';
    }

}
