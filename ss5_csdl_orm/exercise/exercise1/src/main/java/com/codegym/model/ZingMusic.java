package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ZingMusic {
    @Id
    private int id;
    private String song;
    private String name;
    private String type;
    private String link;

    public ZingMusic() {
    }

    public ZingMusic(int id, String song, String name, String type, String link) {
        this.id = id;
        this.song = song;
        this.name = name;
        this.type = type;
        this.link = link;
    }

    public ZingMusic(String song, String name, String type, String link) {
        this.song = song;
        this.name = name;
        this.type = type;
        this.link = link;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
