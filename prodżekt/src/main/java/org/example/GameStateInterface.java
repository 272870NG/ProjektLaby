package org.example;

public interface GameStateInterface {
    void applyGameAction(GameAction gameAction);

    boolean playerIsAlive();

    boolean playerHasReachedDestination();

    String getDestinationName();
    Country findPlayerCountry();
}
