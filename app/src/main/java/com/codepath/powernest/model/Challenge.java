package com.codepath.powernest.model;

import com.codepath.powernest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharonyu on 2017/7/29.
 */

public class Challenge {



    private String challenType;
    private String challenDes;




    public Challenge(String challenType, String challenDes){
        this.challenDes = challenDes;
        this.challenType = challenType;
    }

    public String getChallenType() {
        return challenType;
    }

    public String getChallenDes() {
        return challenDes;
    }



    public static List<Challenge> getChallenges() {
        List<Challenge> challe = new ArrayList<>();
        challe.add(new Challenge("Basic","Challenge for beginners Let's Run!"));
        challe.add(new Challenge("Advanced","Let's start a challenge for yourself"));
        challe.add(new Challenge("Challenge A","Let's start a challenge for yourself"));
        challe.add(new Challenge("Challenge B","Let's start a challenge for yourself"));
        challe.add(new Challenge("Challenge C","Let's start a challenge for yourself"));
        return challe;
    }

}
