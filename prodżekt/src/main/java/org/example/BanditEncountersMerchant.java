package org.example;

import java.util.List;
import java.util.Map;

public class BanditEncountersMerchant implements GameRule{
    @Override
    public Map<GameObject, Country> applyRule(Map<GameObject, Country> currentState, List<Country> europe) {
        System.out.println("Bandit encounters merchant?");
        System.out.println("---------------------------");
        // Znajdz handlarza
        GameObjectFinder finder = new GameObjectFinder();

        GameObject merchant = finder.findMerchant(currentState);
        Country currentMerchantCountry = currentState.get(merchant);

        // Znajdz bandyte
        GameObject bandit = finder.findBandit(currentState);
        if(bandit == null){return currentState;}
        Country currentBanditCountry = currentState.get(bandit);
        Bandit bandit1 = (Bandit) bandit;

        if (currentMerchantCountry.equals(currentBanditCountry)) {
            System.out.println("Bandit robs merchant");
            System.out.println("--------------------");
            if(Math.round(Math.random()) == 1){bandit1.getAttackUpgrade();}
            else{bandit1.getHealthUpgrade();}
        }
        return currentState;
    }
}
