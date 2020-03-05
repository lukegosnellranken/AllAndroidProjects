package com.gmail.gosnellwebdesign.recyclerviewblues;

public class HockeyTeam {
    //instance variables
    private String name;
    private String positionPlayed;
    private String number;

    //No-Arg constructor
    public HockeyTeam(){

    }

    //Full-Arg constructor
    public HockeyTeam(String name, String positionPlayed, String number){
        this.name = name;
        this.positionPlayed = positionPlayed;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPositionPlayed() {
        return positionPlayed;
    }

    public void setPositionPlayed(String positionPlayed) {
        this.positionPlayed = positionPlayed;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
