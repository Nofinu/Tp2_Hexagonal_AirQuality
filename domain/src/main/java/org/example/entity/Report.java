package org.example.entity;

import org.example.enums.Pollution;

import java.util.Date;

public class Report {
    private int id;
    private double longitude;
    private double latitude;
    private Date dateAndHours;
    private Pollution pollution;
    private String comment;

    public Report(double longitude, double latitude, Date dateAndHours, int pollution, String comment) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.dateAndHours = dateAndHours;
        this.pollution = pollution == 1 ? Pollution.FAIBLE : pollution == 2 ? Pollution.MODERER : Pollution.DANGEREUX;
        this.comment = comment;
    }

    public Report(int id, double longitude, double latitude, Date dateAndHours, Pollution pollution, String comment) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.dateAndHours = dateAndHours;
        this.pollution = pollution;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public Date getDateAndHours() {
        return dateAndHours;
    }

    public void setDateAndHours(Date dateAndHours) {
        this.dateAndHours = dateAndHours;
    }

    public Pollution getPollution() {
        return pollution;
    }

    public void setPollution(Pollution pollution) {
        this.pollution = pollution;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
