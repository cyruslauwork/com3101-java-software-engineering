/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com3101_project_group6;

import java.util.*;
/**
 *
 * @author cyrus
 */
public class Model {

    private static Model _instance;
    private Controller controller;
    // using playerList[x].getXXX for getting player information
    List<Player> playerList = new ArrayList<>();
    // using properties[x].getXXX for getting properties information
    List<Property> properties = new ArrayList();
    // using GameRule[x].getXXX for getting GameRule information
    GameRule gr = new GameRule(1500,200,3);
    List<Integer> tokenList = new ArrayList<>();
    private CareTaker caretaker = new CareTaker();
    
    private Model() {
        // Private constructor to prevent direct instantiation
    }

    public static Model getInstance() {
        if (_instance == null) {
            _instance = new Model();
        }
        return _instance;
    }

    public void setController(Controller c) {
        this.controller = c;
    }
    
    public void save(){
        Memento m = new Memento(playerList,properties,gr,tokenList);
        caretaker.addMemento(m);
    }
    
    public void undo(){
        Memento m = caretaker.removeMemento();
        if (m != null) {
            playerList = m.getPlayerList();
            properties = m.getProperties();
            gr = m.getGr();
            tokenList = m.getTokenList();
            // do update
        }else{
            // show error message
        }
    }
    
    // adding 10 token
    void addToken(){
        for(int i = 0;i<10;i++){
            tokenList.add(i);
        }
    }
    
    void addPlayer(String name, int token){
        Player player = new Player(gr.getBaseBalance(), name, token, 0, 0, false, true, false, false);
        for(int i=0;i<=tokenList.size();i++){
            if(tokenList.get(i) == token){
                tokenList.remove(i);
            }
        }
        playerList.add(player);
    }
    
    void setBot(int amount){
        // limit the number of bot (0-3)
        String name = "bot";
        if(amount <=3 && amount >= 0){
            // do something
            for(int i = 0;i<amount;i++){
                addBot(name + amount);
            }
        }else{
            //show message: not correct number of Bot,please config again
        }
    }
    void addBot(String name){
        Random random = new Random();
        int randomIndex = random.nextInt(tokenList.size());
        Player player = new Player(gr.getBaseBalance(), name, tokenList.get(randomIndex), 0, 0,false, true, false, false);
        for(int i=0;i<=tokenList.size();i++){
            if(tokenList.get(i) == tokenList.get(randomIndex)){
                tokenList.remove(i);
            }
        }
        playerList.add(player);
    }
    
    // Modify who's turn it is to move 
    public void move(String playerName){
        for(Player player:playerList){
            if(player.getName().equals(playerName)){
                player.setHisTurn(true);
            }
        }
    }
    
    // after move, in turn end he should stop move
    public void stop(String playerName){
        for(Player player:playerList){
            if(player.getName().equals(playerName)){
                player.setHisTurn(false);
            }
        }
    }
    
    // gen a random number
    public int rollDice(){
        Random random = new Random();
        int diceRoll = random.nextInt(6) + 1;
        return diceRoll;
    }
    
    // add Property to the game
    public void addProperty(){
        Property property0 = new Property("Go", 0, 0, "", 0);
        Property property1 = new Property("D Building", 1, 60, "", 2);
        Property property2 = new Property("M704", 2, 100, "", 4);
        //Bus Stop 25 if 1 owned, 50 if 2 owned, 100 if 3 owned, 200 if all 4 owned
        Property property3 = new Property("KL to HSU", 3, 200, "", 0);
        //Special Fees
        Property property4 = new Property("Tuition Fees", 4, 0, "", 100);
        Property property5 = new Property("M705", 5, 60, "", 4);
        //Bus Stop
        Property property6 = new Property("To KL", 6, 200, "", 25);
        Property property7 = new Property("A Building", 7, 100, "", 6);
        Property property8 = new Property("B Building", 8, 100, "", 6);
        Property property9 = new Property("N Building", 9, 100, "", 6);
        // On Jail, pay 50 to leave or rolling doubles, stay 2 turn and left in his/her third turn
        Property property10 = new Property("Jail", 10, 0, "", 50);
        // Bus Stop
        Property property11 = new Property("ST to HSU", 11, 200, "", 0);
        // Canteen 3×dice if 1 owned, 6×dice if 2 owned, 9×dice if 3 owned,  12×dice if 4 owned
        Property property12 = new Property("A Cafe", 12, 150, "", 0);
        Property property13 = new Property("College Hall", 13, 120, "", 8);
        // Bus Stop
        Property property14 = new Property("To ST", 14, 200, "", 0);
        Property property15 = new Property("M703", 15, 350, "", 35);
        Property property16 = new Property("M702", 16, 400, "", 50);
        // Canteen
        Property property17 = new Property("M Can", 17, 150, "", 0);
        Property property18 = new Property("Createive Humanities Hub", 18, 260, "", 22);
        Property property19 = new Property("Residential Colleges", 19, 140, "", 10);
        // Free Parking
        Property property20 = new Property("Free Parking", 20, 0, "", 0);
        Property property21 = new Property("Old Hall", 21, 140, "", 10);
        // Canteen
        Property property22 = new Property("D Building", 22, 150, "", 0);
        Property property23 = new Property("Staff Quarters", 23, 160, "", 12);
        Property property24 = new Property("Clock Tower", 24, 220, "", 18);
        Property property25 = new Property("The Way", 25, 220, "", 18);
        Property property26 = new Property("Wei Lun Square", 26, 180, "", 14);
        Property property27 = new Property("Outdoor Swimming Pool", 27, 240, "", 20);
        // Canteen
        Property property28 = new Property("Kwong Kuan", 28, 150, "", 0);
        Property property29 = new Property("Basketball Court", 29, 260, "", 22);
        // Go to Jail
        Property property30 = new Property("Go To Jail", 30, 0, "", 0);
        Property property31 = new Property("Indoor Swimming Pool", 31, 280, "", 24);
        Property property32 = new Property("B Build Hall", 32, 300, "", 26);
        // Special Fees
        Property property33 = new Property("Learning Material Fees", 33, 0, "", 100);
        Property property34 = new Property("B Build Music Room", 34, 180, "", 14);
        Property property35 = new Property("B Build Multi-purpose Room", 35, 200, "", 16);
        // Special Fees
        Property property36 = new Property("RC Fees", 36, 0, "", 100);
        Property property37 = new Property("G/F Library",37, 300, "", 26);
        // Special Fees
        Property property38 = new Property("SU Member-ship Subscription", 38, 60, "", 100);
        Property property39 = new Property("1/F Library", 39, 320, "", 28);
        properties.add(property0);
        properties.add(property1);
        properties.add(property2);
        properties.add(property3);
        properties.add(property4);
        properties.add(property5);
        properties.add(property6);
        properties.add(property7);
        properties.add(property8);
        properties.add(property9);
        properties.add(property10);
        properties.add(property11);
        properties.add(property12);
        properties.add(property13);
        properties.add(property14);
        properties.add(property15);
        properties.add(property16);
        properties.add(property17);
        properties.add(property18);
        properties.add(property19);
        properties.add(property20);
        properties.add(property21);
        properties.add(property22);
        properties.add(property23);
        properties.add(property24);
        properties.add(property25);
        properties.add(property26);
        properties.add(property27);
        properties.add(property28);
        properties.add(property29);
        properties.add(property30);
        properties.add(property31);
        properties.add(property32);
        properties.add(property33);
        properties.add(property34);
        properties.add(property35);
        properties.add(property36);
        properties.add(property37);
        properties.add(property38);
        properties.add(property39);
        
    }
    
    // who buy it, and which property
    public void buyProperty(String playerName, String propertyName){
        int cost = 0;
        for (Property property : properties) {
            // same property name ,no owner and able to buy
            if (property.getName().equals(propertyName) && property.getOwner().length() <= 0 && property.getPrice() > 0) {
                property.setOwner(playerName);
                cost = property.getPrice();
            }
        }
        for (Player player:playerList){
            // player who need to pay, reduce his balance
            if (player.getName().equals(playerName)){
                player.setBalance(player.getBalance() - cost);
                //buy success
            }
        }
        //buy failed
    }
    
    // input player name that who need to pay
    public void payRentforProperty(String playerName, String propertyName){
        int cost = 0;
        String owner = "";
        // check rent and owner
        for (Property property : properties) {
            if (property.getName().equals(propertyName)) {
                cost = property.getRent();
                owner = property.getOwner();
            }
        }
        // total balance add the new rent equal the new balance
        for (Player player:playerList){
            // player who need to pay, reduce his balance
            if (player.getName().equals(playerName)){
                player.setBalance(player.getBalance() - cost);
            }
            // player who own it, raise his balance
            if (player.getName().equals(owner)){
                player.setBalance(player.getBalance() + cost);
            }
        }
    }
    
    // who need to pay, and which busStop
    public void payRentforBusStop(String playerName, String busStop){
        int count = 0;
        String busStopOwner = "";
        for(Property property : properties){
            if(property.getName().equals(busStop)){
                busStopOwner = property.getOwner();
            }
        }
        for(Property property : properties){
            if(property.getPrice() == 200 && property.getRent() == 0 && property.getOwner().equals(busStopOwner)){
                count++;
            }
        }
        int cost = 0;
        switch(count){
            case 2:
                cost = 50;
                break;
            case 3:
                cost = 100;
                break;
            case 4:
                cost = 200;
                break;
            default:
                cost = 25;
        }
        for(Player player:playerList){
            if(player.getName().equals(playerName)){
                player.setBalance(player.getBalance() - cost);
            }
            if (player.getName().equals(busStopOwner)){
                player.setBalance(player.getBalance() + cost);
            }
        }
    }
    
    // who need to pay, and which canteen
    public void payCanteen(String playerName, String canteen, int diceNumber){
        int count = 0;
        String canteenOwner = "";
        for(Property property : properties){
            if(property.getName().equals(canteen)){
                canteenOwner = property.getOwner();
            }
        }
        for(Property property : properties){
            if(property.getPrice() == 150 && property.getRent() == 0 && property.getOwner().equals(canteenOwner)){
                count++;
            }
        }
    }
    
    //player need to pay special fee
    public void payFees(String playerName){
        for(Player player:playerList){
            if(player.getName().equals(playerName)){
                player.setBalance(player.getBalance() - 100);
            }
        }
    }
    
    //by property
    public void tradePropertyByProperty(String playerName, String hisProperty, String onwer, String ownerProperty){
        //change owner ship player1 to player2
        for(Property property : properties){
            if(property.getName().equals(hisProperty) && property.getOwner().equals(playerName)){
                property.setOwner(onwer);
            }
        }
        //change owner ship player2 to player1
        for(Property property : properties){
            if(property.getName().equals(ownerProperty) && property.getOwner().equals(onwer)){
                property.setOwner(playerName);
            }
        }
    }
    
    //by money
    public void tradePropertyByMoney(String playerName, int money,String targetProperty, String owner){
        // player reduce money
        for(Player player:playerList){
            if(player.getName().equals(playerName)){
                player.setBalance(player.getBalance() - money);
            }
        }
        // owner increase money
        for(Player player:playerList){
            if(player.getName().equals(playerName)){
                player.setBalance(player.getBalance() + money);
            }
        }
        
        // change owner ship
        for(Property property : properties){
            if(property.getName().equals(targetProperty) && property.getOwner().equals(owner)){
                property.setOwner(playerName);
            }
        }
    }
    
    //Who stop, and who's next
    public void endTrun(){
        noBankrupt();
        save();
    }
    
    // end game with one player that is not Bankrupt
    public void noBankrupt(){
        int count = 0;
        List<Player> playerListForEndGame = new ArrayList();
        for (Player player:playerList){
            if(player.isBankrupt() == true){
                count++;
            }else if(player.isBankrupt() == false){
                playerListForEndGame.add(player);
            }
        }
        // end game
        if(playerListForEndGame.size() == 1){
            // winner playerListForEndGame.get(0)
            String winner = playerListForEndGame.get(0).getName();
        } // keep going the game
        else{
            
        }
    }
    
    // end game with player have the most balance and price of proprety
    public void theMostValue(){
        int theMostTotalValue = 0;
        int totalValue = 0;
        String winner = "";
        for (Player player:playerList){
            for (Property property : properties) {
                if(player.equals(property.getOwner())){
                    totalValue=+property.getPrice();
                }
            }
            totalValue=+player.getBalance();
            if(totalValue>theMostTotalValue){
                theMostTotalValue = totalValue;
                winner = player.getName();
            }
        }
    }
    
    // Player step on go to jail
    public void jailed(String playerName){
        for (Player player:playerList){
            if (player.getName().equals(playerName) && player.isOnJail() == false && player.getStep() == 30){
               player.setOnJail(true);
               player.setStep(10);
            }
        }
    }
    
    // roll dice to leave
    public void rollDiceToLeaveJail(String playerName, int diceNumber){
        // id dice number = 2,4,6, then out
        boolean isSuccess = false;
        if(diceNumber % 2 == 0){
            isSuccess = true;
        }
        for (Player player:playerList){
            if (player.getName().equals(playerName) && player.isOnJail() == true && isSuccess == true){
               player.setOnJail(false);
            }
        }
    }
    // pay to leave jail
    public void payToLeaveJail(String playerName){
        for (Player player:playerList){
            if (player.getName().equals(playerName) && player.isOnJail() == true ){
               player.setBalance(player.getBalance() - 50);
               player.setOnJail(false);
            }
        }
    }
    // third turn to leave
    public void timeToLeaveJail(String playerName){
        for (Player player:playerList){
            if (player.getName().equals(playerName) && player.isOnJail() == true && player.getTurnOnJail() == 2){
                player.setTurnOnJail(0);
                player.setOnJail(false);
            }else if(player.getName().equals(playerName) && player.isOnJail() == true && player.getTurnOnJail() < 2){
                player.setTurnOnJail(player.getTurnOnJail()+1);
            }
        }
    }
    
    //Modify the ownership of a land slot 
    public void changeOwnership(String propretyName, String newOwner){
        for(Property property : properties){
            if(property.getName().equals(propretyName)){
                property.setOwner(newOwner);
            }
        }
    }
    
    //Modify the balance of a player
    public void changeBalance(String playerName, int balance){
        for(Player player:playerList){
            if(player.getName().equals(playerName)){
                player.setBalance(balance);
            }
        }
    }
    
    //Modify the location of a player  0-39, ref to proprety list id
    public void changeLocation(String playerName, int location){
        for(Player player:playerList){
            if(player.getName().equals(playerName)){
                player.setBalance(location);
            }
        }
    }
    
    //Modify the status of a player (active or bankrupt) 
    public void changeLocation(String playerName, boolean active){
        for(Player player:playerList){
            if(player.getName().equals(playerName)){
                player.setBankrupt(active);
            }
        }
    }
    
}
