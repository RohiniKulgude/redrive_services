package com.hackathon.redrive_rest;

public class Dealer {

    private String username;
    private String password;
    private String name;
    private int id;
    private static int counter;

    public Dealer(){
    }

    public Dealer(String name){
        this.name = name;
        this.username = "1";
        this.password = "2";
        this.id = 1;
    }

    public Dealer(Dealer dealer) {
        this.id = ++counter;
        this.name = dealer.name;
        this.username = dealer.username;
        this.password = dealer.password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
