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
        view.board().changeBalance(true);
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

    public void viewSetBalance(boolean changeStatus) {
        view.board().changeBalance(changeStatus);
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

    public void modifyPlayerBalance(int playerNo, int amount, boolean editor) {
        model.modifyPlayerBalance(playerNo, amount, editor);
    }

    public int getPlayerTurn() {
        return model.getPlayerTurn();
    }

    public boolean checkBankrupt(int playerNo) {
        return model.checkBankrupt(playerNo);
    }

    public void viewSetMsg(String msg, boolean alert) {
        view.board().setMsg(msg, alert);
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

    public void provideBuy(int playerNo, int newPos) {
        model.provideBuy(playerNo, newPos);
    }

    public void showPropertyName(String propertyName) {
        view.board().showPropertyName(propertyName);
    }

    public void showPropertyVal(int propertyVal) {
        view.board().showPropertyVal(propertyVal);
    }

    public void setBuyEnable() {
        view.board().setBuyEnable();
    }

    public void setBuyDisable() {
        view.board().setBuyDisable();
    }

    public void buyProperty() {
        model.buyProperty();
    }

    public int getPropertyVal() {
        return view.board().getPropertyVal();
    }

    public void setOwner(int playerNo, int thisTurnPos) {
        view.board().setOwner(playerNo, thisTurnPos);
    }

    public void changePropertyValue(int position, int price, int rent) {
        model.changePropertyValue(position, price, rent);
    }
}
