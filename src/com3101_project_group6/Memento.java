package com3101_project_group6;

import java.util.*;

public class Memento {
    private List<Player> playerList;
    private List<Property> properties;
    private GameRule gr;
    private List<Integer> tokenList;

    public Memento(List<Player> playerList, List<Property> properties, GameRule gr, List<Integer> tokenList) {
        this.playerList = playerList;
        this.properties = properties;
        this.gr = gr;
        this.tokenList = tokenList;
    }
    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public GameRule getGr() {
        return gr;
    }

    public List<Integer> getTokenList() {
        return tokenList;
    }
}