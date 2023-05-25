package org.example;

import java.util.List;
import java.util.Map;

public interface GameRule {

    Map<GameObject, Country> applyRule(Map<GameObject, Country> currentState, List<Country> hallway);
}
