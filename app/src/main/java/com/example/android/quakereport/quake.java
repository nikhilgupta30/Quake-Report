package com.example.android.quakereport;

import java.util.Date;

/**
 * Created by nikhi on 30-12-2017.
 */

public class quake {

    private double mag;
    private String place;
    private long date;
    private String url;

    public quake(double mag,String place,long date,String url){
        this.mag = mag;
        this.place = place;
        this.date = date;
        this.url = url;
    }

    public double getMag(){
        return mag;
    }

    public String getPlace(){
        return place;
    }

    public long getDate(){
        return date;
    }

    public String getUrl(){
        return url;
    }

}
