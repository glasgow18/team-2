package com.example.discovery.discovery;

public class ActivityPreview {

    private String activityName, address, url;
    private float price;
    private int activityId;

    public ActivityPreview(int activityId, String activityName, String address, float price, String latitude, String longitude) {

        this.activityId = activityId;
        this.activityName = activityName;
        this.address = address;
        this.price = price;
        this.url = "http://maps.google.com/maps/api/staticmap?center=" + latitude + "," + longitude + "&zoom=15&size=200x200&sensor=false";

    }

    public int getActivityId() {
        return activityId;
    }
    public String getAddress() {
        return address;
    }

    public String getActivityName() {
        return activityName;
    }

    public float getPrice() {
        return price;
    }

    public String getURL() { return url; }


}
