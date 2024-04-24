/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com3101_project_group6;

/**
 *
 * @author cyrus
 */
public class Controller {

    private static Controller _instance;
    private Model model;
    private View view;

    private Controller() {
        // Private constructor to prevent direct instantiation
    }

    public static Controller getInstance() {
        if (_instance == null) {
            _instance = new Controller();
        }
        return _instance;
    }

    public void setModel(Model m) {
        this.model = m;
    }

    public void setView(View v) {
        this.view = v;
    }

    //Undo
    public void modelUndo(){
        model.undo();
    }

    //addTokens
    public void addTokensToModel() {
        model.addToken();
    }
    //add player
    public void addPlayerToModel(String name, int token) {
        model.addPlayer(name, token);
    }
    //set bot
    public void setNumBots(int amount) {
        model.setBot(amount);
    }

    //add bot
    public void addBotToModel(String name) {
        model.addBot(name);
    }

    public void movePlayerInModel(String playerName) {
        model.move(playerName);
    }

    public void stopPlayerInModel(String playerName) {
        model.stop(playerName);
    }

    public int rollDiceInModel() {
        return model.rollDice();
    }

    public void addPropertiesInModel() {
        model.addProperty();
    }

    public void buyPropertyInModel(String playerName, String propertyName) {
        model.buyProperty(playerName, propertyName);
    }

    public void payRentForPropertyInModel(String playerName, String propertyName) {
        model.payRentforProperty(playerName, propertyName);
    }

    public void payRentForBusStopInModel(String playerName, String busStop) {
        model.payRentforBusStop(playerName, busStop);
    }

    public void payCanteenInModel(String playerName, String canteen, int diceNumber) {
        model.payCanteen(playerName, canteen, diceNumber);
    }

    public void payFeesInModel(String playerName) {
        model.payFees(playerName);
    }

    public void tradePropertyByPropertyInModel(String playerName, String hisProperty, String owner, String ownerProperty) {
        model.tradePropertyByProperty(playerName, hisProperty, owner, ownerProperty);
    }

    public void tradePropertyByMoneyInModel(String playerName, int money, String targetProperty, String owner) {
        model.tradePropertyByMoney(playerName, money, targetProperty, owner);
    }

    public void endTurnInModel() {
        model.endTrun();
    }

    public void checkBankruptPlayersInModel() {
        model.noBankrupt();
    }

    public void theMostValue() {
        model.theMostValue();
    }

    public void jailPlayer(String playerName) {
        model.jailed(playerName);
    }

    public void rollDiceToLeaveJail(String playerName, int diceNumber) {
        model.rollDiceToLeaveJail(playerName, diceNumber);
    }

    public void payToLeaveJail(String playerName) {
        model.payToLeaveJail(playerName);
    }

    public void timeToLeaveJail(String playerName) {
        model.timeToLeaveJail(playerName);
    }

    public void changeOwnership(String propertyName, String newOwner) {
        model.changeOwnership(propertyName, newOwner);
    }

    public void changeBalance(String playerName, int balance) {
        model.changeBalance(playerName, balance);
    }

    public void changeLocation(String playerName, int location) {
        model.changeLocation(playerName, location);
    }

    public void playerStatusChange(String playerName, boolean active) {
        model.playerStatusChange(playerName, active);
    }
    
}
