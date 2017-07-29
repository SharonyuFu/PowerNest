package com.codepath.powernest.model;

import com.codepath.powernest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharonyu on 2017/7/29.
 */

public class Club {
    private String cName;
    private String cLocation;
    private Boolean cIsLoved;
    public int cPhotoUrl;
    private Integer cGroupmembers;
    private Integer cUpcomingmembers;
    private Integer cMessages;

    public Club(){
        // Defualt constructor
    }

    public Club(String name, String location, Boolean isLoved, int photo,Integer groupmembers,Integer upcomingmembers,Integer messages){
        cName = name;
        cLocation = location;
        cIsLoved = isLoved;
        cPhotoUrl = photo;
        cGroupmembers = groupmembers;
        cUpcomingmembers =  upcomingmembers;
        cMessages = messages;

    }

    public String getcName() {
        return cName;
    }

    public String getcLocation() {
        return cLocation;
    }

    public Boolean getcIsLoved() {
        return cIsLoved;
    }

    public int getcPhoto() {
        return cPhotoUrl;
    }

    public int getcGroupmembers() {
        return cGroupmembers;
    }
    public int getcUpcomingmembers() {
        return cUpcomingmembers;
    }
    public int getcMessages() {
        return cMessages;
    }



    public static List<Club> getClubs() {
        List<Club> clubs = new ArrayList<>();
        clubs.add(new Club("Dann Running Group","Daan",true,R.drawable.daan_park,241,11,3));
        clubs.add(new Club("Running Girls","Hualian",true,R.drawable.comboun,100,5,1));

        return clubs;
    }




}

