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
    private View view;
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

    public int rollDice() {
        if (model.getPlaying()) {
            int diceNum = model.rollDice();
            view.board().changeDicePicture(diceNum);
            return diceNum;
        } else {
            return 0;
        }
    }

    public void startGame() {
        model.resetGame();
        view.board().changeBalance();
        view.board().changePos();
        view.board().changeDicePicture(model.getDice());
        model.setPlaying(true);
    }

    public boolean getPlaying() {
        return model.getPlaying();
    }

    public void move() {
        model.move();
    }

    public void viewMoveToken(int playerNo, int move) {
        view.board().moveToken(playerNo, move);
    }

    public int getPlayerBalance(int playerNo) {
        return model.getPlayerBalance(playerNo);
    }

    public void viewSetBalance() {
        view.board().changeBalance();
    }

    public void endTurn() {

    }

    public void EndGame() {
        model.setPlaying(false);
    }

    public void checkAvailableProperty() {
    }

    public int getPlayerPos(int playerNo) {
        return model.getPlayerPos(playerNo);
    }

    public void setPlayerPos(int playerNo, int pos) {
        model.setPlayerPos(playerNo, pos);
    }

    public void modifyPlayerBalance(int playerNo, int amount) {
        model.modifyPlayerBalance(playerNo, amount);
    }

    public int getPlayerTurn() {
        return model.getPlayerTurn();
    }

    public boolean checkBankrupt(int playerNo) {
        return model.checkBankrupt(playerNo);
    }

    public void viewSetMsg(String msg) {
        view.board().setMsg(msg);
    }

    public void playerBalanceDeduction(int playerNo, int newPos) {
        model.playerBalanceDeduction(playerNo, newPos);
    }

    public void disableRollDice() {
        view.board().disableRollDice();
    }

    public void enableRollDice() {
        view.board().enableRollDice();
    }

}
