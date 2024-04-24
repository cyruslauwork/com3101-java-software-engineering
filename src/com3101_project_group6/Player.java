/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com3101_project_group6;

import java.util.*;
/**
 *
 * @author peterli
 */
public class Player {
    private int balance;
    private String name;
    private int token;
    private int step;
    private int turnOnJail;
    private boolean hisTurn;
    private boolean isPlayer;
    private boolean onJail;
    private boolean Bankrupt;
    
    public Player(int balance, String name, int token, int step, int turnOnJail, boolean hisTurn,boolean isPlayer, boolean onJail, boolean isBankrupt) {
        this.balance = balance;
        this.name = name;
        this.token = token;
        this.step = step;
        this.turnOnJail = turnOnJail;
        this.isPlayer = isPlayer;
        this.onJail = onJail;
        this.Bankrupt = isBankrupt;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public int getTurnOnJail() {
        return turnOnJail;
    }

    public void setTurnOnJail(int turnOnJail) {
        this.turnOnJail = turnOnJail;
    }
    
    public boolean isHisTurn() {
        return hisTurn;
    }

    public void setHisTurn(boolean hisTurn) {
        this.hisTurn = hisTurn;
    }

    public boolean isIsPlayer() {
        return isPlayer;
    }

    public void setIsPlayer(boolean isPlayer) {
        this.isPlayer = isPlayer;
    }

    public boolean isOnJail() {
        return onJail;
    }

    public void setOnJail(boolean onJail) {
        this.onJail = onJail;
    }

    public boolean isBankrupt() {
        return Bankrupt;
    }

    public void setBankrupt(boolean isBankrupt) {
        this.Bankrupt = isBankrupt;
    }
    
    
    
}
