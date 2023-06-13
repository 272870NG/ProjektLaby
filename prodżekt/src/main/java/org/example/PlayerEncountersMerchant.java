package org.example;

import java.util.List;
import java.util.Map;

public class PlayerEncountersMerchant implements GameRule{
    @Override
    public Map<GameObject, Country> applyRule(Map<GameObject, Country> currentState, List<Country> europe) {
        System.out.println("Player encounters merchant?");
        System.out.println("---------------------------");
        // Znajdz gracza
        GameObject player = currentState.keySet()
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElseThrow();
        Country currentPlayerCountry = currentState.get(player);

        // Znajdz handlarza
        Country currentMerchantCountry;
        GameObject merchant;
        try {
            merchant = currentState.keySet()
                    .stream()
                    .filter(gameObject -> gameObject instanceof Merchant)
                    .findFirst()
                    .orElseThrow();
            currentMerchantCountry = currentState.get(merchant);
        }
        catch(Exception NoSuchEllementException){return currentState;}
        if (currentMerchantCountry.equals(currentPlayerCountry)) {
            System.out.println("Pokaz mi swoje towary");
            System.out.println("--------------------");
            if(new UserPrompter().dealingWithMerchant() == 0){player.getWeapon();}
            else{player.getSteroids();}
        }
        return currentState;
    }
}
