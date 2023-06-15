package org.example;

import java.util.List;
import java.util.Map;

public class FixedGameState {

    static GameStateHolder get() {

        Country startingCountry = new Country("Poland", List.of("Germany","Hungary","Ukraine","Slovakia"));
        Country country1 = new Country("Ukraine",List.of("Hungary","Slovakia","Poland"));
        Country country2 = new Country("Germany",List.of("Poland","Czechia","Austria","France","Belgium","Netherlands"));
        Country country3 = new Country("Hungary",List.of("Romania","Slovakia","Austria","Slovenia"));
        Country country4 = new Country("Slovakia",List.of("Poland","Czechia","Hungary","Austria","Ukraine"));
        Country country5 = new Country("Czechia",List.of("Poland","Slovakia","Germany","Austria"));
        Country country6 = new Country("Austria",List.of("Czechia","Slovakia","Italy","Hungary","Germany","Slovenia","Switzerland"));
        Country country7 = new Country("Romania",List.of("Hungary","Ukraine"));
        Country country8 = new Country("France",List.of("Germany","Belgium","Spain","Italy","Switzerland"));
        Country country9 = new Country("Spain",List.of("Portugal","France"));
        Country country10 = new Country("Portugal",List.of("Spain"));
        Country country11 = new Country("Slovenia",List.of("Italy","Austria","Hungary"));
        Country country12 = new Country("Switzerland",List.of("France","Austria","Germany","Italy"));
        Country country13 = new Country("Italy",List.of("Switzerland","France","Austria"));
        Country country14 = new Country("Netherlands",List.of("Belgium","Germany"));
        Country country15 = new Country("Belgium",List.of("Netherlands","France","Germany"));

        List<Country> europe = List.of(
                startingCountry,
                country1,country8,country15,
                country2,country9,
                country3,country10,
                country4,country11,
                country5,country12,
                country6,country13,
                country7,country14
        );


        Player player = new Player();
        Country destination = europe.get((int)Math.round(Math.random() * 14 + 1));

        int randomBanditCountry = 2;
//        while(true){
//            randomBanditCountry = (int)Math.round(Math.random() * 14 + 1);
//            if(!destination.getName().equals(europe.get(randomBanditCountry).getName())){break;}
//        }

        Bandit bandit = new Bandit();

        int randomMerchantCountry = 1;
//        while(true){
//            randomMerchantCountry = (int)Math.round(Math.random() * 14 + 1);
//            if(!destination.getName().equals(europe.get(randomMerchantCountry).getName())){break;}
//        }

        Merchant merchant = new Merchant();


        return new GameStateHolder(
                europe,
                Map.of(player, startingCountry,
                        bandit, europe.get(randomBanditCountry),
                        merchant, europe.get(randomMerchantCountry)),
                destination
        );
    }
}
