package com3101_project_group6;

import java.util.*;

class CareTaker {

    private ArrayList<Memento> undoList = new ArrayList<>();

    public void addMemento(Memento m) {
        undoList.add(0, m);
    }

    public Memento removeMemento() {

        if (!undoList.isEmpty()) {
            Memento m = undoList.remove(0);
            return m;
        } else {
            return null;
        }
    }
}