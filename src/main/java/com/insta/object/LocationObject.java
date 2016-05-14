package com.insta.object;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by gleb on 14.05.16.
 */
@XmlRootElement
public class LocationObject {

    private String latitude;
    private String id;
    private String longitude;
    private String name;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "LocationObject{" +
                "latitude='" + latitude + '\'' +
                ", id='" + id + '\'' +
                ", longitude='" + longitude + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
