package com.example.hcgologin;

public class ConerItem {
    String name;
    String place;
    String people;
    String time;
    int resld;



    public ConerItem(String name, String place, int resldm, String people, String time){
        this.name = name;
        this.place = place;
        this.people = people;
        this.time = time;
        this.resld = resld;
    }

    public String getPlace() {
        return place;
    }

    public String getPeople() {
        return people;
    }

    public String getTime() {
        return time;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setName(String name) { //Alt + ins로 getter, setter 생성 가능,
        this.name = name;
    }

    public void setResld(int resld) {
        this.resld = resld;
    }

    public String getName() {
        return name;
    }

    public int getResld() {
        return resld;
    }

    public String toString(){
        return "ConerItem{" + "name='" + name + '\'' + ", place='"+ place +'\'' + ", people='"+ people + '\'' + ", time ='"+ time +'\'' + '}';
    }

}
