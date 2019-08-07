package com.example.greenflag;

public class Profile {

    public String name, userName, password, birthDate, country, gender;
    public int age;


    public Profile(String name, String userName, String password, String birthDate, String country, String gender, int age) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.country = country;
        this.gender = gender;
        this.age = age;
    }

    public Profile() {
        this.name = "";
        this.userName = "";
        this.password = "";
        this.birthDate = "";
        this.country = "";
        this.gender = "";
        this.age = 0;
    }
}
