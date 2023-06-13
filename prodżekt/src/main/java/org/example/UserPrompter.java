package org.example;

import java.util.List;
import java.util.Scanner;

public class UserPrompter {

    public int askForNextCountry (Country currentPlayerCountry, List<Country> europe){
        int countryOfChoice = 0;
        for(String country: currentPlayerCountry.getNeighbours()){
            System.out.print(countryOfChoice + "-" + country + " ");
            countryOfChoice++;
        }
        while(true) {
            System.out.print("\nTo choose next country type an appropriate number: ");
            countryOfChoice = new Scanner(System.in).next().charAt(0) - 48;
            System.out.println("----------------------------------------------------");
            if(countryOfChoice < currentPlayerCountry.getNeighbours().size()){break;}
        }
        for(Country country:europe){
            if(country.getName().equals(currentPlayerCountry.getNeighbours().get(countryOfChoice))){
                countryOfChoice = europe.indexOf(country);
                break;
            }
        }
        return countryOfChoice;
    }
    public int dealingWithMerchant() {
        int upgradeOfChoice;
        System.out.println("Weapon upgrade: 0\nHealth upgrade: 1");
        do {
            System.out.print("\nTo choose what to buy type an appropriate number: ");
            upgradeOfChoice = new Scanner(System.in).next().charAt(0) - 48;
            System.out.println("--------------------------------------------------");
        }while(upgradeOfChoice > 1 || upgradeOfChoice < 0);
        return upgradeOfChoice;
    }
}
