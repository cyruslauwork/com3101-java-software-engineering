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
    private static View view;
    private Model model;

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
    
    
    public void startGame(String[] playerNameList,int[] playerToken, int numberOfBot){
        int count = 0;
        model.addToken();
        model.addProperty();
        model.setBot(numberOfBot);
        for(String playerName:playerNameList){
            model.addPlayer(playerName, playerToken[count]);
            count++;
        }
    }
    
    public int rollDice(){
        return model.rollDice();
    }
    
}
