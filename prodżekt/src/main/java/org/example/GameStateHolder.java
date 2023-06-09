package org.example;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

public class GameStateHolder implements GameStateInterface{
    private static List<GameRule> RULES_TO_APPLY_EACH_PLAYER_ACTION = List.of(
            new PlayerEncountersMerchant(), new PlayerEncountersBandit()
    );
    private static List<GameRule> RULES_TO_APPLY_EACH_BANDIT_ACTION = List.of(
            new BanditEncountersMerchant(), new PlayerEncountersBandit()
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

        if(gameAction instanceof PlayerMove) {
            for (GameRule rule : RULES_TO_APPLY_EACH_PLAYER_ACTION) {
                this.gameMap = rule.applyRule(this.gameMap, europe);
            }
        } else if (gameAction instanceof BanditMove) {
            for (GameRule rule : RULES_TO_APPLY_EACH_BANDIT_ACTION) {
                this.gameMap = rule.applyRule(this.gameMap, europe);
            }
        }
    }

    public boolean playerIsAlive() {
            return gameMap.keySet()
                    .stream()
                    .anyMatch(gameObject -> gameObject instanceof Player);
    }

    public boolean playerHasReachedDestination() {
        return destination.equals(findPlayerCountry());
    }

    public String getDestinationName(){return destination.getName();}
    public Country findPlayerCountry() {
        try {
            GameObjectFinder finder = new GameObjectFinder();
            GameObject player = finder.findPlayer(gameMap);

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
