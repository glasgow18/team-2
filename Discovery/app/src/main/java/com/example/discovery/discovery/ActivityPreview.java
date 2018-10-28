package com.example.discovery.discovery;

public class ActivityPreview {

    private String activityName, thumbURL, fullURL;
    private float price;
    private int activityId;

    public ActivityPreview(int activityId, String activityName, float price, String latitude, String longitude) {

        this.activityId = activityId;
        this.activityName = activityName;
        this.price = price;
        this.thumbURL = "http://maps.google.com/maps/api/staticmap?center=" + latitude + "," + longitude + "&zoom=15&size=200x200&sensor=false";
        this.fullURL = "https://www.google.com/maps/search/?api=1&query=" + latitude + "," + longitude;
    }

    public int getActivityId() {
        return activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public float getPrice() {
        return price;
    }

    public String getThumbURL() { return thumbURL; }

    public String getFullURL() { return fullURL; }


}
