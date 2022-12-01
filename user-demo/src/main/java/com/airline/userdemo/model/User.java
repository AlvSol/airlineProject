package com.airline.userdemo.model;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;

    private String name;
    private String surname;
    private String nationality;
    private int age;

    private int ageGroup;

    public User() {

    }

    public User(String id, String name, String surname, String nationality, int ageGroup) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.age = 30;
        this.ageGroup = ageGroup;
    }

    public User(String name, String surname, String nationality, int ageGroup) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.age = 30;
        this.ageGroup = ageGroup;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(int ageGroup) {
        this.ageGroup = ageGroup;
    }

    @Override
    public boolean equals(Object obj) {

        if(!obj.getClass().equals(User.class)) {
            return false;
        }

        if(!((User) obj).id.equals(this.id)) {
            return false;
        }

        if(!((User) obj).name.equals(this.name)) {
            return false;
        }

        if(!((User) obj).surname.equals(this.surname)) {
            return false;
        }

        return ((User) obj).nationality.equals(this.nationality);
    }
}
