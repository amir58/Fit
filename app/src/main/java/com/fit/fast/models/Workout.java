package com.fit.fast.models;

import androidx.navigation.NavType;

import java.io.Serializable;

public class Workout implements Serializable {

    private String name;
    private String sets;
    private String reps;
    private String link;
    private String photo;

    public Workout(String name, String sets, String reps, String link, String photo) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;
        this.link = link;
        this.photo = photo;
    }

    public Workout() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "name='" + name + '\'' +
                ", sets='" + sets + '\'' +
                ", reps='" + reps + '\'' +
                ", link='" + link + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
