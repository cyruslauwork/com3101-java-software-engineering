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
    {0,150,0},{0,120,8},{0,200,0},{0,350,35},{0,400,50},{0,150,0},{0,260,22},{0,140,10},{5,0,0},{0,140,10},{0,150,0}
    ,{0,160,12},{0,220,18},{0,220,18},{0,180,14},{0,240,20},{0,150,0},{0,260,22},{5,0,0},{0,280,24},{0,300,26},{5,0,100}
    ,{0,180,14},{0,200,16},{5,0,0},{0,300,26},{0,60,100},{0,320,28}};

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

    public int getPlayerPos(int player_no){ 
        if(player_no == 2){
            return player_two_pos;
        }
        else if(player_no == 3){
            return player_three_pos;
        }
        else if(player_no == 4){
            return player_four_pos;
        }
        return player_one_pos;
    }
    
    
    // gen a random number
    public int rollDice(){
        Random random = new Random();
        int diceRoll = random.nextInt(6) + 1;
        return diceRoll;
    }

    public void reset(){
        playing = true;
        dice_num = 0;
        turn_of_player_no = 1;
        player_one_pos = 1;
        player_two_pos = 1;
        player_three_pos = 1;
        player_four_pos = 1;
    }

    public void move(){
        int dice_num = controller.rollDice();
        System.out.println(dice_num);
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
            player_one_balance = amount;
        } else if (player_no == 2) {
            player_two_balance = amount;
        } else if (player_no == 3) {
            player_three_balance = amount;
        } else {
            player_four_balance = amount;
        }
        controller.viewSetBalance();
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
    public void setPlayerPos(int player_no, int pos) {
        if(player_no == 1){
            player_one_pos = pos;
        }else if(player_no == 2){
            player_two_pos = pos;
        }else if(player_no == 3){
            player_three_pos = pos;
        }
        else if(player_no ==4){
            player_four_pos = pos;
        }
        
    }

    public int getPlayerTurn(){
        return turn_of_player_no;
    }

    
}
