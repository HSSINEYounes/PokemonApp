package com.example.myapplication;

public class Charachter {
    private String name;
    private String exp;
    private String hp;
    private String height;
    private String weight;

    public Charachter(String name, String exp, String hp, String height, String weight) {
        this.name = name;
        this.exp = exp;
        this.hp = hp;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getExp() {
        return exp;
    }

    public String getHp() {
        return hp;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }
}
