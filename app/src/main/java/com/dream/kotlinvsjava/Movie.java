package com.dream.kotlinvsjava;

import java.util.Date;

public class Movie {

    private int id;
    private String name;
    private Date releaseDate;

    public Movie() {
    }

    public Movie(int id, String name, Date releaseDate) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "id :" + id +
                ", name : " + name +
                ", releaseDate: " + releaseDate;
    }
}
