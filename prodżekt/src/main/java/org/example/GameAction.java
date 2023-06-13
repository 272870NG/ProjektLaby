package org.example;

import java.util.List;
import java.util.Map;

public interface GameAction {

    Map<GameObject, Country> applyAction(Map<GameObject, Country> currentState, List<Country> europe);
}
