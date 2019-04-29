package com.example.myapplication.Listview;

public class map_block {
    private double lati_start;
    private double longi_start;
    private double lati_dest;
    private double longi_dest;
    private String start;
    private String dest;

    public map_block(double lati_start, double longi_start,double lati_dest, double longi_dest) {
        this.lati_start = lati_start;
        this.longi_start = longi_start;
        this.lati_dest = lati_dest;
        this.longi_dest= longi_dest;

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


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }
}
