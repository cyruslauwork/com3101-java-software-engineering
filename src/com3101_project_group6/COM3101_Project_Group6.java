/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com3101_project_group6;

import java.io.IOException;

/**
 *
 * @author LAU Ka Pui (s226064)
 * @author LI Kam Ki (s225380)
 * @author CHAN Chun Wa (s208150)
 */
public class COM3101_Project_Group6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        View view = View.getInstance();
        Model model = Model.getInstance();
        Controller controller = Controller.getInstance();
        Board board = Board.getInstance();

        view.setController(controller);
        view.setBoard(board);
        model.setController(controller);
        controller.setView(view);
        controller.setModel(model);
       
        view.showBoard();
    }

}
