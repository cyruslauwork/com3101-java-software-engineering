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
    List<Memento> playerList = new ArrayList<>();

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
    
    void setPlayer(int amount){
        // player number (1-4)
        if(amount <=3 && amount >= 0){
            // do something
        }else{
            //show message: not correct number of player,please config again
        }
        
    }
    void setBot(int amount){
        // limit the number of bot (0-3)
        if(amount <=3 && amount >= 0){
            // do something
        }else{
            //show message: not correct number of Bot,please config again
        }
    }
    void startGame(){
        
    } 
    void rollDice(){
        
    }
    void buyProperty(){
        
    }
    void payRentforProperty(){
        
    }
    void payRentforBusStop(){
        
    }
    void payTax(){
        
    }
    void tradeProperty(){
        
    }
    void endTrun(){
        
    }
    void endGame(){
        
    }
    void jailed(){
        
    }
}
