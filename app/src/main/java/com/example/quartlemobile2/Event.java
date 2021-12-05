package com.example.quartlemobile2;

import androidx.annotation.NonNull;

public class Event {

    private String attendants;
    private String capacity;
    private String date;
    private String goals;
    private String location;
    private String name;
    private String points;
    private String purpose;
    private String user;

    public Event() {
    }

    public Event(String attendants, String capacity, String date, String goals,
                 String location, String name, String points, String purpose, String user) {
        this.attendants = attendants;
        this.capacity = capacity;
        this.date = date;
        this.goals = goals;
        this.location = location;
        this.name = name;
        this.points = points;
        this.purpose = purpose;
        this.user = user;
    }

    public String getAttendants() {
        return attendants;
    }

    public void setAttendants(String attendants) {
        this.attendants = attendants;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

}
