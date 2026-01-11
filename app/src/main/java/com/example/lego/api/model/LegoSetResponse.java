package com.example.lego.api.model;

import java.util.List;

public class LegoSetResponse {

    private int count;
    private String next;
    private String previous;
    private List<LegoSet> results;

    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<LegoSet> getResults() {
        return results;
    }
}