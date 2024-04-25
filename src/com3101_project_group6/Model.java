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
    private CareTaker caretaker = new CareTaker();

    private int num_player = 0;
    private int num_bot = 0;
    private boolean playing = false;
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    public boolean getPlaying(){
        return playing;
    }

    private int dice_num = 0;
    private int turn_of_player_no = 1;
    private int player_one_pos = 1;
    private int player_two_pos = 1;
    private int player_three_pos = 1;
    private int player_four_pos = 1;
    private int player_one_balance = 1;
    private int player_two_balance = 1;
    private int player_three_balance = 1;
    private int player_four_balance = 1;
    // onwer and price and rent
    private int[][] propertyList = {{5,0,0},{0,60,2},{0,100,4},{0,200,0},{5,0,100},{0,60,4},{0,200,0},{0,100,6},{0,100,6},{0,100,6},{5,0,0},{0,200,0},{0,150,0},{0,120,8},{0,200,0},
    {0,150,0},{0,120,8},{0,200,0},{0,350,35},{0,}};

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
    
    
    // gen a random number
    public int rollDice(){
        Random random = new Random();
        int diceRoll = random.nextInt(6) + 1;
        return diceRoll;
    }

    public void reset(){
        num_player = 0;
        num_bot = 0;
        playing = false;
        dice_num = 0;
        turn_of_player_no = 1;
        player_one_pos = 1;
        player_two_pos = 1;
        player_three_pos = 1;
        player_four_pos = 1;
    }

    public void move(){
        int dice_num = controller.rollDice();
        if (turn_of_player_no == 1) {
            controller.moveToken(turn_of_player_no, dice_num);
            player_one_pos += dice_num;
            turn_of_player_no++;
        } else if (turn_of_player_no == 2) {
            controller.moveToken(turn_of_player_no, dice_num);
            player_two_pos += dice_num;
            turn_of_player_no++;
        } else if (turn_of_player_no == 3) {
            controller.moveToken(turn_of_player_no, dice_num);
            player_three_pos += dice_num;
            turn_of_player_no++;
        } else {
            controller.moveToken(turn_of_player_no, dice_num);
            player_four_pos += dice_num;
            turn_of_player_no = 1;
        }
    }

    public void modifyPlayerBalance(int player_no, int amount){
        if (player_no == 1) {
            player_one_balance += amount;
        } else if (player_no == 2) {
            player_two_balance += amount;
        } else if (player_no == 3) {
            player_three_balance += amount;
        } else {
            player_four_balance += amount;
        }
    }

    public void modifyPlayerPos(int player_no, int amount){
        if (player_no == 1) {
            player_one_pos = amount;
            controller.moveToken(turn_of_player_no, dice_num);
        } else if (player_no == 2) {
            player_two_pos = amount;
            controller.moveToken(turn_of_player_no, dice_num);
        } else if (player_no == 3) {
            player_three_pos = amount;
            controller.moveToken(turn_of_player_no, dice_num);
        } else {
            player_four_pos = amount;
            controller.moveToken(turn_of_player_no, dice_num);
        }
    }

    public void modifyPlayerTurn(int player_no){
        if (player_no == 1) {
            turn_of_player_no = 1;
        } else if (player_no == 2) {
            turn_of_player_no = 2;
        } else if (player_no == 3) {
            turn_of_player_no = 3;
        } else {
            turn_of_player_no = 4;
        }
    }

    public void checkLocation() {
        // TODO a swtich check player position and modify player balance
        if(turn_of_player_no == 1){
            if(player_one_pos == 1){
                
            }
        }
    }

    public int getPlayerBalance(int player_no){
        if(player_no == 1){
            return player_one_balance;
        }else if(player_no == 2){
            return player_two_balance;
        }else if(player_no == 3){
            return player_three_balance;
        }else if(player_no ==4){
            return player_four_balance;
        }


        return player_one_balance;
    }

    
}
