package com.example.pianokids;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class RData extends RealmObject {


    private String id;
    private String word,jword,imglink;
   private Integer n,v;

    public RData() {
    }

    public RData(String id, String word, String jword, String imglink, Integer n, Integer v) {
        this.id = id;
        this.word = word;
        this.jword = jword;
        this.imglink = imglink;
        this.n = n;
        this.v = v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getJword() {
        return jword;
    }

    public void setJword(String jword) {
        this.jword = jword;
    }

    public String getImglink() {
        return imglink;
    }

    public void setImglink(String imglink) {
        this.imglink = imglink;
    }

    public Integer getN() {
        return n;
    }

    public void setN(Integer n) {
        this.n = n;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
