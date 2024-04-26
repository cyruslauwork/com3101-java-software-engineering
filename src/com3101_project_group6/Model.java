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
    private int nextTurnPlayerNo = 1;
    private int playerOnePo = 1;
    private int playerTwoPos = 1;
    private int playerThreePos = 1;
    private int playerFourPos = 1;
    private int playerOneBal = 0;
    private int playerTwoBal = 0;
    private int playerThreeBal = 0;
    private int playerFourBal = 0;
    private boolean playerOneBankrupt = false;
    private boolean playerTwoBankrupt = false;
    private boolean playerThreeBankrupt = false;
    private boolean playerFourBankrupt = false;
    private int thisTurnPos = 0;

    public void bankrupt() {
        if (playerOneBal < 0) {
            playerOneBankrupt = true;
            // System.out.println("Player 1 is bankrupt");
        }
        if (playerTwoBal < 0) {
            playerTwoBankrupt = true;
            // System.out.println("Player 2 is bankrupt");
        }
        if (playerThreeBal < 0) {
            playerThreeBankrupt = true;
            // System.out.println("Player 3 is bankrupt");
        }
        if (playerFourBal < 0) {
            playerFourBankrupt = true;
            // System.out.println("Player 4 is bankrupt");
        }
    }

    public boolean checkBankrupt(int playerNo) {
        if (playerNo == 1) {
            if (playerOneBankrupt) {
                return true;
            }
        } else if (playerNo == 2) {
            if (playerTwoBankrupt) {
                return true;
            }
        } else if (playerNo == 3) {
            if (playerThreeBankrupt) {
                return true;
            }
        } else if (playerNo == 4) {
            if (playerFourBankrupt) {
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
            { "D Building", "0", "200", "1" },
            { "M704", "0", "50", "1" },
            { "KL to HSU", "0", "9999", "15" },
            { "Tuition Fees", "5", "9999", "30" },
            { "M705", "0", "50", "1" },
            { "To KL", "0", "9999", "15" },
            { "A Building", "0", "200", "1" },
            { "B Building", "0", "150", "1" },
            { "N Building", "0", "100", "1" },
            { "Jail", "0", "9999", "0" },
            { "ST to HSU", "0", "9999", "15" },
            { "A Cafe", "0", "100", "20" },
            { "College Hall", "0", "150", "1" },
            { "To ST", "0", "9999", "15" },
            { "M703", "0", "50", "1" },
            { "M702", "0", "50", "1" },
            { "M Can", "0", "200", "20" },
            { "CR", "0", "200", "1" },
            { "RC", "0", "400", "1" },
            { "Free Parking", "0", "9999", "0" },
            { "Old Hall", "0", "100", "1" },
            { "D Can", "0", "100", "15" },
            { "Staff Quarters", "0", "250", "1" },
            { "Clock Tower", "0", "50", "1" },
            { "The Way", "0", "50", "1" },
            { "Wei Lun Square", "0", "50", "1" },
            { "Outdoor pool", "0", "50", "5" },
            { "Kwong Yuen", "0", "9999", "10" },
            { "B. Court", "0", "50", "1" },
            { "Go To Jail", "0", "9999", "10" },
            { "Indoor pool", "0", "100", "10" },
            { "B Build Hall", "0", "100", "5" },
            { "Materials", "0", "9999", "10" },
            { "Music Room", "0", "50", "5" },
            { "Multi-purpose", "0", "50", "5" },
            { "RC Fees", "0", "9999", "30" },
            { "G/F Libra.", "0", "150", "1" },
            { "SU Fee", "0", "9999", "10" },
            { "1/F Libra.", "0", "150", "1" },
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
            return playerTwoPos;
        } else if (playerNo == 3) {
            return playerThreePos;
        } else if (playerNo == 4) {
            return playerFourPos;
        }
        return playerOnePo;
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
        nextTurnPlayerNo = 1;

        playerOnePo = 1;
        playerTwoPos = 1;
        playerThreePos = 1;
        playerFourPos = 1;

        playerOneBal = 100;
        playerTwoBal = 100;
        playerThreeBal = 100;
        playerFourBal = 100;

        playerOneBankrupt = false;
        playerTwoBankrupt = false;
        playerThreeBankrupt = false;
        playerFourBankrupt = false;

        controller.enableRollDice();
    }

    public void move() {
        int diceNum = controller.rollDice();
        if (nextTurnPlayerNo == 1) {
            controller.viewMoveToken(nextTurnPlayerNo, diceNum);
            if (playerTwoBankrupt) {
                nextTurnPlayerNo++;
                if (playerThreeBankrupt) {
                    nextTurnPlayerNo++;
                    if (playerFourBankrupt) {
                        playing = false;
                        controller.disableRollDice();
                        controller.viewSetMsg("Player one win!", false);
                        return;
                    }
                }
            }
            nextTurnPlayerNo++;
            if (nextTurnPlayerNo > 4) {
                nextTurnPlayerNo -= 4;
            }
        } else if (nextTurnPlayerNo == 2) {
            controller.viewMoveToken(nextTurnPlayerNo, diceNum);
            if (playerThreeBankrupt) {
                nextTurnPlayerNo++;
                if (playerFourBankrupt) {
                    nextTurnPlayerNo++;
                    if (playerOneBankrupt) {
                        playing = false;
                        controller.viewSetMsg("Player two win!", false);
                        controller.disableRollDice();
                        return;
                    }
                }
            }
            nextTurnPlayerNo++;
            if (nextTurnPlayerNo > 4) {
                nextTurnPlayerNo -= 4;
            }
        } else if (nextTurnPlayerNo == 3) {
            controller.viewMoveToken(nextTurnPlayerNo, diceNum);
            if (playerFourBankrupt) {
                nextTurnPlayerNo++;
                if (playerOneBankrupt) {
                    nextTurnPlayerNo++;
                    if (playerTwoBankrupt) {
                        playing = false;
                        controller.disableRollDice();
                        controller.viewSetMsg("Player three win!", false);
                        return;
                    }
                }
            }
            nextTurnPlayerNo++;
            if (nextTurnPlayerNo > 4) {
                nextTurnPlayerNo -= 4;
            }
        } else if (nextTurnPlayerNo == 4) {
            controller.viewMoveToken(nextTurnPlayerNo, diceNum);
            if (playerOneBankrupt) {
                nextTurnPlayerNo++;
                if (playerTwoBankrupt) {
                    nextTurnPlayerNo++;
                    if (playerThreeBankrupt) {
                        playing = false;
                        controller.disableRollDice();
                        controller.viewSetMsg("Player four win!", false);
                        return;
                    }
                }
            }
            nextTurnPlayerNo++;
            if (nextTurnPlayerNo > 4) {
                nextTurnPlayerNo -= 4;
            }
        }
    }

    public void modifyPlayerBalance(int playerNo, int amount) {
        if (playerNo == 1) {
            playerOneBal = amount;
        } else if (playerNo == 2) {
            playerTwoBal = amount;
        } else if (playerNo == 3) {
            playerThreeBal = amount;
        } else {
            playerFourBal = amount;
        }
        controller.viewSetBalance(true);
    }

    public void modifyPlayerTurn(int playerNo) {
        if (playerNo == 1) {
            nextTurnPlayerNo = 1;
        } else if (playerNo == 2) {
            nextTurnPlayerNo = 2;
        } else if (playerNo == 3) {
            nextTurnPlayerNo = 3;
        } else {
            nextTurnPlayerNo = 4;
        }
    }

    public int getPlayerBalance(int playerNo) {
        bankrupt();
        if (playerNo == 1) {
            return playerOneBal;
        } else if (playerNo == 2) {
            return playerTwoBal;
        } else if (playerNo == 3) {
            return playerThreeBal;
        } else {
            return playerFourBal;
        }
    }

    public void setPlayerPos(int playerNo, int pos) {
        if (playerNo == 1) {
            playerOnePo = pos;
        } else if (playerNo == 2) {
            playerTwoPos = pos;
        } else if (playerNo == 3) {
            playerThreePos = pos;
        } else if (playerNo == 4) {
            playerFourPos = pos;
        }
    }

    public int getPlayerTurn() {
        return nextTurnPlayerNo;
    }

    public int getDice() {
        return diceNum;
    }

    public void playerBalanceDeduction(int playerNo, int newPos) {
        int deduction = 0;
        int ownerNo = Integer.valueOf(propertyList[newPos - 1][1]);
        if (ownerNo != playerNo) { // If not owner
            deduction = Integer.valueOf(propertyList[newPos - 1][3]); // Rent
            if (playerNo == 1) {
                playerOneBal -= deduction;
                if (ownerNo == 1) {
                    playerOneBal += deduction;
                } else if (ownerNo == 2) {
                    playerTwoBal += deduction;
                } else if (ownerNo == 3) {
                    playerThreeBal += deduction;
                } else if (ownerNo == 4) {
                    playerFourBal += deduction;
                }
            } else if (playerNo == 2) {
                playerTwoBal -= deduction;
                if (ownerNo == 1) {
                    playerOneBal += deduction;
                } else if (ownerNo == 2) {
                    playerTwoBal += deduction;
                } else if (ownerNo == 3) {
                    playerThreeBal += deduction;
                } else if (ownerNo == 4) {
                    playerFourBal += deduction;
                }
            } else if (playerNo == 3) {
                playerThreeBal -= deduction;
                if (ownerNo == 1) {
                    playerOneBal += deduction;
                } else if (ownerNo == 2) {
                    playerTwoBal += deduction;
                } else if (ownerNo == 3) {
                    playerThreeBal += deduction;
                } else if (ownerNo == 4) {
                    playerFourBal += deduction;
                }
            } else if (playerNo == 4) {
                playerFourBal -= deduction;
                if (ownerNo == 1) {
                    playerOneBal += deduction;
                } else if (ownerNo == 2) {
                    playerTwoBal += deduction;
                } else if (ownerNo == 3) {
                    playerThreeBal += deduction;
                } else if (ownerNo == 4) {
                    playerFourBal += deduction;
                }
            }
        }
    }

    public void provideBuy(int playerNo, int newPos) {
        thisTurnPos = newPos;
        // System.out.println(playerNo);
        if (Integer.valueOf(propertyList[newPos - 1][1]) != playerNo) { // If not owner
            int propertyVal = Integer.valueOf(propertyList[newPos - 1][2]); // Property value
            controller.showPropertyVal(propertyVal);
            String propertyName = propertyList[newPos - 1][0]; // Property value
            controller.showPropertyName(propertyName);
            controller.setBuyEnable();
        } else {
            controller.setBuyDisable();
        }
    }

    public void buyProperty() {
        if (nextTurnPlayerNo == 1) {
            int playerNo = 4;
            int propertyVal = controller.getPropertyVal();
            if (playerFourBal >= propertyVal) {
                playerFourBal -= propertyVal;
                propertyList[thisTurnPos - 1][1] = String.valueOf(playerNo);
                controller.setOwner(playerNo, thisTurnPos);
                String propertyName = propertyList[thisTurnPos - 1][0];
                controller.viewSetMsg(propertyName + " is now player 4", false);
                controller.viewSetBalance(false);
            } else {
                controller.viewSetMsg("Insufficient balance", true);
            }
        } else if (nextTurnPlayerNo == 2) {
            int playerNo = 1;
            int propertyVal = controller.getPropertyVal();
            if (playerOneBal >= propertyVal) {
                playerOneBal -= propertyVal;
                propertyList[thisTurnPos - 1][1] = String.valueOf(playerNo);
                controller.setOwner(playerNo, thisTurnPos);
                String propertyName = propertyList[thisTurnPos - 1][0];
                controller.viewSetMsg(propertyName + " is now player 1", false);
                controller.viewSetBalance(false);
            } else {
                controller.viewSetMsg("Insufficient balance", true);
            }
        } else if (nextTurnPlayerNo == 3) {
            int playerNo = 2;
            int propertyVal = controller.getPropertyVal();
            if (playerTwoBal >= propertyVal) {
                playerTwoBal -= propertyVal;
                propertyList[thisTurnPos - 1][1] = String.valueOf(playerNo);
                controller.setOwner(playerNo, thisTurnPos);
                String propertyName = propertyList[thisTurnPos - 1][0];
                controller.viewSetMsg(propertyName + " is now player 2", false);
                controller.viewSetBalance(false);
            } else {
                controller.viewSetMsg("Insufficient balance", true);
            }
        } else if (nextTurnPlayerNo == 4) {
            int playerNo = 3;
            int propertyVal = controller.getPropertyVal();
            if (playerThreeBal >= propertyVal) {
                playerThreeBal -= propertyVal;
                propertyList[thisTurnPos - 1][1] = String.valueOf(playerNo);
                controller.setOwner(playerNo, thisTurnPos);
                String propertyName = propertyList[thisTurnPos - 1][0];
                controller.viewSetMsg(propertyName + " is now player 3", false);
                controller.viewSetBalance(false);
            } else {
                controller.viewSetMsg("Insufficient balance", true);
            }
        }
    }
}
