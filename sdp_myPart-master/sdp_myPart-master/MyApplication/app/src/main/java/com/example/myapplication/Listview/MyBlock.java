package com.example.myapplication.Listview;

import android.widget.Button;

public class MyBlock {
    private int statinID;
    private int type;
    private String location;
    private String descript;
    private Button button;
    private double lati_start;
    private double longi_start;
    private double lati_dest;
    private double longi_dest;

    public Button getButton() {
        return button;
    }

    public MyBlock(int statinID, int type, String location, String descript/*,double lati_start, double longi_start,double lati_dest, double longi_dest*/ ) {
        this.statinID = statinID;
        this.type = type;
        this.location = location;
        this.descript = descript;
        /*this.lati_start = lati_start;
        this.longi_start = longi_start;
        this.lati_dest = lati_dest;
        this.longi_dest= longi_dest;*/
    }

    public int getStatinID() {
        return statinID;
    }

    public int getType() {
        return type;
    }

    public void setButton(Button button) {
        this.button = button;

    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public double getLati_start() {
        return lati_start;
    }

    public double getLongi_start() {
        return longi_start;
    }

    public double getLati_dest() {
        return lati_dest;
    }

    public double getLongi_dest() {
        return longi_dest;
    }
}
