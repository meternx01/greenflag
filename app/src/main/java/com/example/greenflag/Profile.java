package com.example.greenflag;

public class Profile {

    public String name, userName, password, birthDate, country;
    public int age;

    public Profile(String name, String userName, String password, String birthDate, String country, int age) {
        this.name = name;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.country = country;
        this.age = age;
    }
}
