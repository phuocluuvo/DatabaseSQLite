package com.example.databaseexamplecontact;

public class Place {
    private String name;
    private int id;

    public Place() {

    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Place(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
