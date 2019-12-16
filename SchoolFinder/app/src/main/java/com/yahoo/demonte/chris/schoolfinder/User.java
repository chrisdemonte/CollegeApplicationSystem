package com.yahoo.demonte.chris.schoolfinder;

import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {
    private static final long serialVersionUID = 5207569929571426681L;
    private String name;
    private String username;
    private String password;
    private String email;
    private int mathScore;
    private int readingScore;
    private ArrayList<String> favorites;

    public User(String name, String username, String password, String email, int mathScore, int readingScore) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.mathScore = mathScore;
        this.readingScore = readingScore;
        this.favorites = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getReadingScore() {
        return readingScore;
    }

    public void setReadingScore(int readingScore) {
        this.readingScore = readingScore;
    }

    public ArrayList<String> getFavorites() {
        return favorites;
    }

    public void setFavorites(ArrayList<String> favorites) {
        this.favorites = favorites;
    }


    public String toSpecialString() {
        String favs = "";
        if (this.favorites.size() == 0){
            favs = "-1";
        }
        else {
            for (int i = 0; i < this.favorites.size(); i++){
                favs += (favorites.get(i) + ",");
            }
            favs = favs.substring(0, favs.lastIndexOf(","));
        }
        return name + "\n"+ username + "\n" + password + "\n" + email +
                "\n" + mathScore + "\n" + readingScore + "\n" + favs + "\n";
    }
}
