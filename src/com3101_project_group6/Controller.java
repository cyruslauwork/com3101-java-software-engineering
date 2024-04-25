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
        return model.rollDice();
    }

    public void reset(){
        model.reset();
    }

    public void move(){
        model.move();
    }

    public void moveToken(int player_no, int move){
        board.moveToken(player_no,move);
    }
    
    
}
