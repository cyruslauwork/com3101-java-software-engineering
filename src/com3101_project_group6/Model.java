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
    /* 
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
        */
    private int[][] propertyList = {{5,0,0},{0,60,2},{0,100,4},{0,200,0},{5,0,100},{0,60,4},};

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
