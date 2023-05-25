package org.example;

import java.util.List;
import java.util.Map;

public class FixedGameState {

    static GameStateHolder get() {
        Country startingCountry = new Country("Poland", List.of("Germany","Hungary","Ukraine"));
        Country country1 = new Country("Ukraine",List.of("Poland"));
        Country country2 = new Country("Germany",List.of("Poland"));
        Country country3 = new Country("Hungary",List.of("Poland"));

        List<Country> europe = List.of(
                startingCountry,
                country1,
                country2,
                country3
        );


        Player player = new Player("Hungary");

        Bandit bandit = new Bandit();


        return new GameStateHolder(
                europe,
                Map.of(new Player("Hungary"), startingCountry,
                        bandit, country3)
        );
    }
}
