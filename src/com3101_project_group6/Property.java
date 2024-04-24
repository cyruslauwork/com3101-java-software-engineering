/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com3101_project_group6;

import java.util.*;
/**
 *
 * @author weare
 */
public class Property {

    private String name;
    private int id;
    private int price;
    private String owner;
    private int rent;

    public Property(String name, int id, int price, String owner, int rent) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.owner = owner;
        this.rent = rent;
    }
   
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
    
    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }
    
   
}
