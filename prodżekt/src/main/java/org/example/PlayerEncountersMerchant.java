package org.example;

import java.util.List;
import java.util.Map;

public class PlayerEncountersMerchant implements GameRule{
    @Override
    public Map<GameObject, Country> applyRule(Map<GameObject, Country> currentState, List<Country> europe) {
        System.out.println("Player encounters merchant?");
        System.out.println("---------------------------");

        GameObjectFinder finder = new GameObjectFinder();

        GameObject gameObjectPlayer = finder.findPlayer(currentState);
        Country currentPlayerCountry = currentState.get(gameObjectPlayer);
        Player player = (Player) gameObjectPlayer;

        GameObject merchant = finder.findMerchant(currentState);
        Country currentMerchantCountry = currentState.get(merchant);

        if (currentMerchantCountry.equals(currentPlayerCountry)) {
            System.out.println("Pokaz mi swoje towary");
            System.out.println("--------------------");
            if(new UserPrompter().dealingWithMerchant() == 0){player.getAttackUpgrade();}
            else{player.getHealthUpgrade();}
        }
        return currentState;
    }
}
