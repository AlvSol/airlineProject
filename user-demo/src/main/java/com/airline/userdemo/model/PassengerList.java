package com.airline.userdemo.model;

import org.springframework.data.annotation.Id;

import java.util.List;

public class PassengerList {

    @Id
    private int id;

    private String name;
    private List<User> listPassenger;

    public PassengerList() {

    }

    public PassengerList(int id, String name, List<User> listPassenger) {
        this.id = id;
        this.name = name;
        this.listPassenger = listPassenger;
    }

    public PassengerList(String name, List<User> listPassenger) {
        this.name = name;
        this.listPassenger = listPassenger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getListPassenger() {
        return listPassenger;
    }

    public void setListPassenger(List<User> listPassenger) {
        this.listPassenger = listPassenger;
    }
}
