/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com3101_project_group6;

/**
 *
 * @author weare
 */
public class GameRule {
    // Base balance for each player
    private int baseBalance;
    // Go's reward moeny
    private int passGo;
    // turn on jail
    private int turnOnJail;

    public GameRule(int baseBalance, int passGo, int turnOnJail) {
        this.baseBalance = baseBalance;
        this.passGo = passGo;
        this.turnOnJail = turnOnJail;
    }
    public int getBaseBalance() {
        return baseBalance;
    }

    public int getPassGo() {
        return passGo;
    }

    public int getTurnOnJail() {
        return turnOnJail;
    }
}
