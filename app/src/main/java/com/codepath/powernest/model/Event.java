package com.codepath.powernest.model;

import com.codepath.powernest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharonyu on 2017/7/29.
 */

public class Event {

    private String eName;


    private String cName;
    private Boolean cIsJoin;
    private String eDate;
    private String eTime;
    private String eType;

    public int getClubImg() {
        return clubImg;
    }

    private int clubImg;

    public Event(int clubImg,String name, String cName, Boolean isJoin, String date, String time, String type){
        this.eName = name;
        this.cName = cName;
        this.cIsJoin = isJoin;
        this.eDate = date;
        this.eTime = time;
        this.eType = type;
        this.clubImg = clubImg;
    }

    // getter
    public String geteName() {
        return eName;
    }
    public String getcName() {
        return cName;
    }

    public Boolean getcIsJoin() {
        return cIsJoin;
    }

    public String geteDate() {
        return eDate;
    }

    public String geteTime() {
        return eTime;
    }

    public String geteType() {
        return eType;
    }

    public static List<Event> getEvents() {
        List<Event> events = new ArrayList<>();
        events.add(new Event(R.drawable.daan_park,"Party Voting", "Daan Ruuning Group", true,"2017-07-29","19:00","Easy Training"));
        events.add(new Event(R.drawable.odiac,"Odiac Random Day", "Odiac Run", true,"2017-07-30","18:00","Other"));
        events.add(new Event(R.drawable.comboun,"Combo Rush Routine", "Combo Run", true,"2017-08-01","19:00","Interval Training"));
        events.add(new Event(R.drawable.daan_park,"Daan Park LateNight", "Daan Ruuning Group", true,"2017-08-01","21:00","Easy Training"));
        events.add(new Event(R.drawable.odiac,"Odiac Random Day", "Odiac Run", true,"2017-08-03","18:00","Other"));
        events.add(new Event(R.drawable.comboun,"Combo Rush ThursDay", "Combo Run", true,"2017-08-05","19:00","Easy Run"));
        events.add(new Event(R.drawable.daan_park,"Daan Park Wednesday", "Daan Ruuning Group", true,"2017-07-29","19:00","Easy Training"));
        events.add(new Event(R.drawable.odiac,"Odiac Random Day", "Odiac Run", true,"2017-07-30","18:00","Other"));
        events.add(new Event(R.drawable.comboun,"Combo Rush Routine", "Combo Run", true,"2017-08-01","19:00","Interval Training"));

        return events;
    }





}