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
    // private CareTaker caretaker = new CareTaker();

    private boolean playing = false;

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean getPlaying() {
        return playing;
    }

    private int diceNum = 0;
    private int turn_of_playerNo = 1;
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

    public boolean checkBankrupt(int playerNo) {
        if (playerNo == 1) {
            if (player_one_bankrupt) {
                return true;
            }
        } else if (playerNo == 2) {
            if (player_two_bankrupt) {
                return true;
            }
        } else if (playerNo == 3) {
            if (player_three_bankrupt) {
                return true;
            }
        } else if (playerNo == 4) {
            if (player_four_bankrupt) {
                return true;
            }
        }
        return false;
    }

    public String[][] getPropertyList() {
        return propertyList;
    }

    private String[][] propertyList = {
            { "Go", "0", "9999", "0" },
            { "D Building", "0", "200", "10" },
            { "M704", "0", "50", "5" },
            { "KL to HSU", "0", "9999", "15" },
            { "Tuition Fees", "5", "9999", "50" },
            { "M705", "0", "50", "5" },
            { "To KL", "0", "9999", "15" },
            { "A Building", "0", "200", "10" },
            { "B Building", "0", "150", "5" },
            { "N Building", "0", "100", "5" },
            { "Jail", "0", "9999", "0" },
            { "ST to HSU", "0", "9999", "15" },
            { "A Cafe", "0", "100", "30" },
            { "College Hall", "0", "150", "10" },
            { "To ST", "0", "9999", "15" },
            { "M703", "0", "50", "5" },
            { "M702", "0", "50", "5" },
            { "M Can", "0", "200", "35" },
            { "CR", "0", "200", "5" },
            { "RC", "0", "400", "5" },
            { "Free Parking", "0", "9999", "0" },
            { "Old Hall", "0", "100", "10" },
            { "D Can", "0", "100", "35" },
            { "Staff Quarters", "0", "250", "50" },
            { "Clock Tower", "0", "50", "5" },
            { "The Way", "0", "50", "5" },
            { "Wei Lun Square", "0", "50", "5" },
            { "Outdoor pool", "0", "50", "5" },
            { "Kwong Yuen", "0", "9999", "20" },
            { "B. Court", "0", "50", "5" },
            { "Go To Jail", "0", "9999", "50" },
            { "Indoor pool", "0", "100", "10" },
            { "B Build Hall", "0", "100", "10" },
            { "Materials", "0", "9999", "50" },
            { "Music Room", "0", "50", "10" },
            { "Multi-purpose", "0", "50", "10" },
            { "RC Fees", "0", "9999", "50" },
            { "G/F Libra.", "0", "150", "5" },
            { "SU Fee", "0", "9999", "10" },
            { "1/F Libra.", "0", "150", "5" },
    };// Property name, owner no., price, and rent

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

    public int getPlayerPos(int playerNo) {
        if (playerNo == 2) {
            return player_two_pos;
        } else if (playerNo == 3) {
            return player_three_pos;
        } else if (playerNo == 4) {
            return player_four_pos;
        }
        return player_one_pos;
    }

    public int rollDice() {
        Random random = new Random();
        int diceRoll = random.nextInt(6) + 1;
        // System.out.println(diceRoll);
        return diceRoll;
    }

    public void resetGame() {
        playing = false;
        diceNum = 0;
        turn_of_playerNo = 1;

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

        controller.enableRollDice();
    }

    public void move() {
        int diceNum = controller.rollDice();
        if (turn_of_playerNo == 1) {
            controller.viewMoveToken(turn_of_playerNo, diceNum);
            if (player_two_bankrupt) {
                turn_of_playerNo++;
                if (player_three_bankrupt) {
                    turn_of_playerNo++;
                    if (player_four_bankrupt) {
                        playing = false;
                        controller.disableRollDice();
                        controller.viewSetMsg("Player one win!");
                        return;
                    }
                }
            }
            turn_of_playerNo++;
            if (turn_of_playerNo > 4) {
                turn_of_playerNo -= 4;
            }
        } else if (turn_of_playerNo == 2) {
            controller.viewMoveToken(turn_of_playerNo, diceNum);
            if (player_three_bankrupt) {
                turn_of_playerNo++;
                if (player_four_bankrupt) {
                    turn_of_playerNo++;
                    if (player_one_bankrupt) {
                        playing = false;
                        controller.viewSetMsg("Player two win!");
                        controller.disableRollDice();
                        return;
                    }
                }
            }
            turn_of_playerNo++;
            if (turn_of_playerNo > 4) {
                turn_of_playerNo -= 4;
            }
        } else if (turn_of_playerNo == 3) {
            controller.viewMoveToken(turn_of_playerNo, diceNum);
            if (player_four_bankrupt) {
                turn_of_playerNo++;
                if (player_one_bankrupt) {
                    turn_of_playerNo++;
                    if (player_two_bankrupt) {
                        playing = false;
                        controller.disableRollDice();
                        controller.viewSetMsg("Player three win!");
                        return;
                    }
                }
            }
            turn_of_playerNo++;
            if (turn_of_playerNo > 4) {
                turn_of_playerNo -= 4;
            }
        } else if (turn_of_playerNo == 4) {
            controller.viewMoveToken(turn_of_playerNo, diceNum);
            if (player_one_bankrupt) {
                turn_of_playerNo++;
                if (player_two_bankrupt) {
                    turn_of_playerNo++;
                    if (player_three_bankrupt) {
                        playing = false;
                        controller.disableRollDice();
                        controller.viewSetMsg("Player four win!");
                        return;
                    }
                }
            }
            turn_of_playerNo++;
            if (turn_of_playerNo > 4) {
                turn_of_playerNo -= 4;
            }
        }
    }

    public void modifyPlayerBalance(int playerNo, int amount) {
        if (playerNo == 1) {
            player_one_balance = amount;
        } else if (playerNo == 2) {
            player_two_balance = amount;
        } else if (playerNo == 3) {
            player_three_balance = amount;
        } else {
            player_four_balance = amount;
        }
        controller.viewSetBalance();
    }

    public void modifyPlayerTurn(int playerNo) {
        if (playerNo == 1) {
            turn_of_playerNo = 1;
        } else if (playerNo == 2) {
            turn_of_playerNo = 2;
        } else if (playerNo == 3) {
            turn_of_playerNo = 3;
        } else {
            turn_of_playerNo = 4;
        }
    }

    public int getPlayerBalance(int playerNo) {
        bankrupt();
        if (playerNo == 1) {
            return player_one_balance;
        } else if (playerNo == 2) {
            return player_two_balance;
        } else if (playerNo == 3) {
            return player_three_balance;
        } else {
            return player_four_balance;
        }
    }

    public void setPlayerPos(int playerNo, int pos) {
        if (playerNo == 1) {
            player_one_pos = pos;
        } else if (playerNo == 2) {
            player_two_pos = pos;
        } else if (playerNo == 3) {
            player_three_pos = pos;
        } else if (playerNo == 4) {
            player_four_pos = pos;
        }
    }

    public int getPlayerTurn() {
        return turn_of_playerNo;
    }

    public int getDice() {
        return diceNum;
    }

    public void playerBalanceDeduction(int playerNo, int newPos) {
        int deduction = Integer.valueOf(propertyList[newPos - 1][3]);
        if (playerNo == 1) {
            player_one_balance -= deduction;
        } else if (playerNo == 2) {
            player_two_balance -= deduction;
        } else if (playerNo == 3) {
            player_three_balance -= deduction;
        } else if (playerNo == 4) {
            player_four_balance -= deduction;
        }
    }
}
