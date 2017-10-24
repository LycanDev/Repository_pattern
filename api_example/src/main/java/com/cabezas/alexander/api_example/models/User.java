package com.cabezas.alexander.api_example.models;

/**
 * Created by alexandercabezas on 24/10/17.
 */

public class User {

    private String userName;
    private String name;
    private String lastName;
    private String id;

    public User() {
    }

    public User(String userName, String name, String lastName, String id) {
        setUserName(userName);
        setName(name);
        setLastName(lastName);
        setId(id);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
