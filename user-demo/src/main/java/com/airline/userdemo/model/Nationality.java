package com.airline.userdemo.model;

import org.springframework.data.annotation.Id;

public class Nationality {

    @Id
    private String id;

    private String nationality;

    public Nationality() {

    }

    public Nationality(String nationality) {
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
