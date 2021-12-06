package com.example.hcgologin;

public class lvitem {
    String name;
    String people;
    String comment;

    public lvitem(String name, String people, String comment){
        this.name = name;
        this.people = people;
        this.comment = comment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
