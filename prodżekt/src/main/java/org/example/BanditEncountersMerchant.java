package org.example;

import java.util.List;
import java.util.Map;

public class BanditEncountersMerchant implements GameRule{
    @Override
    public Map<GameObject, Country> applyRule(Map<GameObject, Country> currentState, List<Country> europe) {
        GameObjectFinder finder = new GameObjectFinder();

        GameObject merchant = finder.findMerchant(currentState);
        Country currentMerchantCountry = currentState.get(merchant);

        GameObject gameObjectBandit = finder.findBandit(currentState);

        if(gameObjectBandit == null){return currentState;}
        Country currentBanditCountry = currentState.get(gameObjectBandit);
        Bandit bandit = (Bandit) gameObjectBandit;

        if (currentMerchantCountry.equals(currentBanditCountry)) {
            System.out.println("Bandit robs merchant");
            System.out.println("--------------------");
            if(Math.round(Math.random()) == 1){bandit.getAttackUpgrade();}
            else{bandit.getHealthUpgrade();}
            return new MerchantMove().applyAction(currentState,europe);
        }
        return currentState;
    }
}
