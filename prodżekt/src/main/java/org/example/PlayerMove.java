package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class PlayerMove implements GameAction{

    @Override
    public Map<GameObject, Country> applyAction(Map<GameObject, Country> currentState, List<Country> europe) {
        GameObject player = currentState.keySet()
                .stream()
                .filter(gameObject -> gameObject instanceof Player)
                .findFirst()
                .orElseThrow();
        Country currentPlayerCountry = currentState.get(player);


        //wybierz kolejny kraj
        int countryOfChoice = 0;
        for(String country: currentPlayerCountry.getNeighbours()){
            System.out.print(countryOfChoice + "-" + country + " ");
            countryOfChoice++;
        }
        System.out.print("\nTo choose next country type an appropriate number: ");
        countryOfChoice = new Scanner(System.in).next().charAt(0) - 48;
        System.out.println("----------------------------------------------------");

        for(Country country:europe){
            if(country.getName().equals(currentPlayerCountry.getNeighbours().get(countryOfChoice))){
                countryOfChoice = europe.indexOf(country);
                break;
            }
        }

        // stworz nowy stan w oparciu o stary
        HashMap<GameObject,Country> newState = new HashMap<>(currentState);
        // umiesc gracza
        newState.put(player, europe.get(countryOfChoice));
        // zwroc stan
        return newState;
    }
}
