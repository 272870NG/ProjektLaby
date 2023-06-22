package org.example;

public class GameRunner {
    private final GameStateInterface gameStateInterface;
    private final GameActionsProvider gameActionsProvider;

    public GameRunner(GameStateInterface gameStateHolder, GameActionsProvider gameActionsProvider) {
        this.gameStateInterface = gameStateHolder;
        this.gameActionsProvider = gameActionsProvider;
    }

    public void run() {
        do {
            GameAction nextAction = gameActionsProvider.next().get((int)Math.round(Math.random()));
            gameStateInterface.applyGameAction(nextAction);
        } while (gameStateInterface.playerIsAlive() && !gameStateInterface.playerHasReachedDestination());
    }
}
