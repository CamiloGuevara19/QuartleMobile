package com.example.quartlemobile2;

public class User {

    //private String id;
    private String email;
    private String myEvents;
    private String points;
    private String username;

    public User(String email, String myEvents, String points, String username) {
        this.email = email;
        this.myEvents = myEvents;
        this.points = points;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMyEvents() {
        return myEvents;
    }

    public void setMyEvents(String myEvents) {
        this.myEvents = myEvents;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
