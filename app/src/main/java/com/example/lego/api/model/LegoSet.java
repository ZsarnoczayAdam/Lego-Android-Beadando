package com.example.lego.api.model;

import java.io.Serializable;

public class LegoSet implements Serializable {

    private String set_num;
    private String name;
    private int year;
    private int num_parts;
    private String set_img_url;

    public String getSetNum() {
        return set_num;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getNumParts() {
        return num_parts;
    }

    public String getSetImgUrl() {
        return set_img_url;
    }
}