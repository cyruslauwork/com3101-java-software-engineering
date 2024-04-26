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

    public boolean getPlaying() {
        return playing;
    }

    private int dice_num = 0;
    private int turn_of_player_no = 1;
    private int player_one_pos = 1;
    private int player_two_pos = 1;
    private int player_three_pos = 1;
    private int player_four_pos = 1;
    private int player_one_balance = 0;
    private int player_two_balance = 0;
    private int player_three_balance = 0;
    private int player_four_balance = 0;
    private boolean player_one_bankrupt = false;
    private boolean player_two_bankrupt = false;
    private boolean player_three_bankrupt = false;
    private boolean player_four_bankrupt = false;

    public void bankrupt() {
        if (player_one_balance < 0) {
            player_one_bankrupt = true;
            // System.out.println("Player 1 is bankrupt");
        }
        if (player_two_balance < 0) {
            player_two_bankrupt = true;
            // System.out.println("Player 2 is bankrupt");
        }
        if (player_three_balance < 0) {
            player_three_bankrupt = true;
            // System.out.println("Player 3 is bankrupt");
        }
        if (player_four_balance < 0) {
            player_four_bankrupt = true;
            // System.out.println("Player 4 is bankrupt");
        }
    }

    public boolean checkBankrupt(int player_no) {
        if (player_no == 1) {
            if (player_one_bankrupt) {
                return true;
            }
        } else if (player_no == 2) {
            if (player_two_bankrupt) {
                return true;
            }
        } else if (player_no == 3) {
            if (player_three_bankrupt) {
                return true;
            }
        } else if (player_no == 4) {
            if (player_four_bankrupt) {
                return true;
            }
        }
        return false;
    }

    public int[][] getPropertyList() {
        return propertyList;
    }

    // onwer and price and rent
    private int[][] propertyList = { { 5, 0, 0 }, { 0, 60, 2 }, { 0, 100, 4 }, { 0, 200, 0 }, { 5, 0, 100 },
            { 0, 60, 4 }, { 0, 200, 0 }, { 0, 100, 6 }, { 0, 100, 6 }, { 0, 100, 6 }, { 5, 0, 0 }, { 0, 200, 0 },
            { 0, 150, 0 }, { 0, 120, 8 }, { 0, 200, 0 }, { 0, 150, 0 }, { 0, 120, 8 }, { 0, 200, 0 }, { 0, 350, 35 },
            { 0, 400, 50 }, { 0, 150, 0 }, { 0, 260, 22 }, { 0, 140, 10 }, { 5, 0, 0 }, { 0, 140, 10 }, { 0, 150, 0 },
            { 0, 160, 12 }, { 0, 220, 18 }, { 0, 220, 18 }, { 0, 180, 14 }, { 0, 240, 20 }, { 0, 150, 0 },
            { 0, 260, 22 }, { 5, 0, 0 }, { 0, 280, 24 }, { 0, 300, 26 }, { 5, 0, 100 }, { 0, 180, 14 }, { 0, 200, 16 },
            { 5, 0, 0 }, { 0, 300, 26 }, { 0, 60, 100 }, { 0, 320, 28 } };

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

    public int getPlayerPos(int player_no) {
        if (player_no == 2) {
            return player_two_pos;
        } else if (player_no == 3) {
            return player_three_pos;
        } else if (player_no == 4) {
            return player_four_pos;
        }
        return player_one_pos;
    }

    // gen a random number
    public int rollDice() {
        Random random = new Random();
        int diceRoll = random.nextInt(6) + 1;
        // System.out.println(diceRoll);
        return diceRoll;
    }

    public void resetGame() {
        playing = false;
        dice_num = 0;
        turn_of_player_no = 1;

        player_one_pos = 1;
        player_two_pos = 1;
        player_three_pos = 1;
        player_four_pos = 1;

        player_one_balance = 100;
        player_two_balance = 100;
        player_three_balance = 100;
        player_four_balance = 100;

        player_one_bankrupt = false;
        player_two_bankrupt = false;
        player_three_bankrupt = false;
        player_four_bankrupt = false;
    }

    public void move() {
        int dice_num = controller.rollDice();
        if (turn_of_player_no == 1) {
            controller.viewMoveToken(turn_of_player_no, dice_num);
            if (player_two_bankrupt) {
                turn_of_player_no++;
                if (player_three_bankrupt) {
                    turn_of_player_no++;
                    if (player_four_bankrupt) {
                        playing = false;
                        controller.viewSetMsg("Player one win!");
                        return;
                    }
                }
            }
            turn_of_player_no++;
            if (turn_of_player_no > 4) {
                turn_of_player_no -= 4;
            }
        } else if (turn_of_player_no == 2) {
            controller.viewMoveToken(turn_of_player_no, dice_num);
            if (player_three_bankrupt) {
                turn_of_player_no++;
                if (player_four_bankrupt) {
                    turn_of_player_no++;
                    if (player_one_bankrupt) {
                        playing = false;
                        controller.viewSetMsg("Player two win!");
                        return;
                    }
                }
            }
            turn_of_player_no++;
            if (turn_of_player_no > 4) {
                turn_of_player_no -= 4;
            }
        } else if (turn_of_player_no == 3) {
            controller.viewMoveToken(turn_of_player_no, dice_num);
            if (player_four_bankrupt) {
                turn_of_player_no++;
                if (player_one_bankrupt) {
                    turn_of_player_no++;
                    if (player_two_bankrupt) {
                        playing = false;
                        controller.viewSetMsg("Player two win!");
                        return;
                    }
                }
            }
            turn_of_player_no++;
            if (turn_of_player_no > 4) {
                turn_of_player_no -= 4;
            }
        } else if (turn_of_player_no == 4) {
            controller.viewMoveToken(turn_of_player_no, dice_num);
            if (player_one_bankrupt) {
                turn_of_player_no++;
                if (player_two_bankrupt) {
                    turn_of_player_no++;
                    if (player_three_bankrupt) {
                        playing = false;
                        controller.viewSetMsg("Player two win!");
                        return;
                    }
                }
            }
            turn_of_player_no++;
            if (turn_of_player_no > 4) {
                turn_of_player_no -= 4;
            }
        }
    }

    public void modifyPlayerBalance(int player_no, int amount) {
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

    public void modifyPlayerTurn(int player_no) {
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

    public int getPlayerBalance(int player_no) {
        bankrupt();
        if (player_no == 1) {
            return player_one_balance;
        } else if (player_no == 2) {
            return player_two_balance;
        } else if (player_no == 3) {
            return player_three_balance;
        } else {
            return player_four_balance;
        }
    }

    public void setPlayerPos(int player_no, int pos) {
        if (player_no == 1) {
            player_one_pos = pos;
        } else if (player_no == 2) {
            player_two_pos = pos;
        } else if (player_no == 3) {
            player_three_pos = pos;
        } else if (player_no == 4) {
            player_four_pos = pos;
        }

    }

    public int getPlayerTurn() {
        return turn_of_player_no;
    }

    public int getDice() {
        return dice_num;
    }

}
