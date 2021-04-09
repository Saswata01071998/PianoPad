package com.example.pianokids;

import io.realm.RealmObject;

public class RData extends RealmObject {
    public String title;
    public String id;
    public String description;
    public Integer v;

    public RData() {
    }

    public RData(String title, String id, String description, Integer v) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.v = v;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
