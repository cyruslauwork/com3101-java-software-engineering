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
    private Board board;

    public void setBoard(Board board) {
        this.board = board;
    }

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
    
    public int rollDice(){
        if(model.getPlaying()){
            int dice_num = model.rollDice();
            board.changeDicePicture(dice_num);
            return dice_num;
        }else {
            return 0;
        }
    }

    public void statGame(){
        model.setPlaying(true);
        model.reset();
        for(int i = 1; i <= 4; i++){
            model.modifyPlayerBalance(i, 2000);
        }
        
    }

    public void reset(){
        model.reset();
    }

    public void move(){
        model.move();
        model.checkLocation();
    }

    public void moveToken(int player_no, int move){
        board.moveToken(player_no,move);
    }

    public int getPlayerBalance(int player_no){
        return model.getPlayerBalance(player_no);
    } 

    public void viewSetBalance(){
        board.changeBalance();
    }

    public void endTurn(){

    }

    public void EndGame(){
        model.setPlaying(false);
    }

    public void checkAvailableProperty(){
    }

    public void modifyPlayerPos(int player_no, int amount){
        model.modifyPlayerPos(player_no, amount);
    }

    public int getPlayerPos(int player_no){
        return model.getPlayerPos(player_no);
    }

    public void setPlayerPos(int player_no,int pos){
        model.setPlayerPos(player_no,pos);
    }

    public void modifyPlayerBalance(int player_no, int amount){
        modifyPlayerBalance(player_no, amount);
    }

    public int getPlayerTurn(){
        return model.getPlayerTurn();
    }
    
}
