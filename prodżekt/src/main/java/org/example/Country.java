package org.example;

import java.util.List;

public class Country {
    private final String name;
    private final List<String> neighbours;

    public Country(String name, List<String> neighbours) {
        this.name = name;
        this.neighbours = neighbours;
    }

    public List<String> getNeighbours(){return neighbours;}

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                '}';
    }
}
