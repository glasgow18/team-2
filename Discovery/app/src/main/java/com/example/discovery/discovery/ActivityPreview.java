package com.example.discovery.discovery;

public class ActivityPreview {

    private String longitude, latitude, activityName, address, url;
    private float price;

    public ActivityPreview(String activityName, String address, float price, String longitude, String latitude, String url) {

        this.activityName = activityName;
        this.address = address;
        this.price = price;
        this.longitude = longitude;
        this.latitude = latitude;
        this.url = url;

    }

    public String getLongitude() {
        return longitude;
    }

    public String getAddress() {
        return address;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getActivityName() {
        return activityName;
    }

    public float getPrice() {
        return price;
    }

    public String getURL() { return url; }
}
