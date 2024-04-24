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
        Board board = Board.getInstance();
        Model model = Model.getInstance();
        Controller controller = Controller.getInstance();
        
        board.setController(controller);
        model.setController(controller);
        controller.setView(board);
        controller.setModel(model);
       
    }

}
