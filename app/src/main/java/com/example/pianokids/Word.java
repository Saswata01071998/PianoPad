package com.example.pianokids;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Word {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("word")
    @Expose
    private String word;
    @SerializedName("jword")
    @Expose
    private String jword;
    @SerializedName("imglink")
    @Expose
    private String imglink;
    @SerializedName("n")
    @Expose
    private Integer n;
    @SerializedName("__v")
    @Expose
    private Integer v;

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
