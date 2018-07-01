package com.jonathaslima.example.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;

@Document
public  class Post {

    @Id
    private String id;
    @NotNull
    private String tittle;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Post(String id, @NotNull String tittle, String description) {
        this.id = id;
        this.tittle = tittle;
        this.description = description;
    }
}
