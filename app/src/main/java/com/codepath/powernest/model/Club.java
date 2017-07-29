package com.codepath.powernest.model;

/**
 * Created by sharonyu on 2017/7/29.
 */

public class Club {
    private String cName;
    private long cLocation;
    private Boolean cIsLoved;
    public int cPhotoUrl;

    public Club(){
        // Defualt constructor
    }

    public Club(String name, long location, Boolean isLoved, int photo){
        cName = name;
        cLocation = location;
        cIsLoved = isLoved;
        cPhotoUrl = photo;
    }

    public String getcName() {
        return cName;
    }

    public long getcLocation() {
        return cLocation;
    }

    public Boolean getcIsLoved() {
        return cIsLoved;
    }

    public int getcPhoto() {
        return cPhotoUrl;
    }




}

