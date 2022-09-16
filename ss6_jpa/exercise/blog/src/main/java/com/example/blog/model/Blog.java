package com.example.blog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id
    private int id;
    @Column(columnDefinition = "text")
    private String tittle;
    @Column(columnDefinition = "text")
    private String body;
    private String author;
    @Column(columnDefinition = "date")
    private String dateWriting;

    public Blog() {
    }

    public Blog(int id, String tittle, String body, String author, String dateWriting) {
        this.id = id;
        this.tittle = tittle;
        this.body = body;
        this.author = author;
        this.dateWriting = dateWriting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDateWriting() {
        return dateWriting;
    }

    public void setDateWriting(String dateWriting) {
        this.dateWriting = dateWriting;
    }
}
