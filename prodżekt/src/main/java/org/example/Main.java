package org.example;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        GameStateHolder gameState = FixedGameState.get();
        List<GameAction> performedActions = List.of(
                new PlayerMove(),
                new BanditMove()
        );
        System.out.println("--------------------------------------");
        System.out.println("Your destination is: " + gameState.getDestinationName());
        System.out.println("--------------------------------------");
        GameRunner runner = new GameRunner(gameState, () -> performedActions);

        runner.run();

        if(gameState.playerHasReachedDestination() && gameState.playerIsAlive()){
            System.out.println("You reached your destination, great victory");
            System.out.println("-------------------------------------------");
        } else {
            System.out.println("You lost");
            System.out.println("--------");
        }

    }
}