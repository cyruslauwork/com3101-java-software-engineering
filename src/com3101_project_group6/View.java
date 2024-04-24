/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com3101_project_group6;

import java.io.IOException;

/**
 *
 * @author cyrus
 */
public class View {

    private static View _instance;
    private Controller controller;
    private Board board;

    private View() {
        // Private constructor to prevent direct instantiation
    }

    public static View getInstance() {
        if (_instance == null) {
            _instance = new View();
        }
        return _instance;
    }

    public void setController(Controller c) {
        this.controller = c;
    }

    public void setBoard(Board b) {
        this.board = b;
    }

    public void showBoard() throws IOException {
        board.showBoard(controller);
    }
}
