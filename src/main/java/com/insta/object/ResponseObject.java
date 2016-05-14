package com.insta.object;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by gleb on 14.05.16.
 */
@XmlRootElement
public class ResponseObject {

    private LocationObject locationObject;

    private List<String> imegUrls;

    public LocationObject getLocationObject() {
        return locationObject;
    }

    public void setLocationObject(LocationObject locationObject) {
        this.locationObject = locationObject;
    }

    public List<String> getImegUrls() {
        return imegUrls;
    }

    public void setImegUrls(List<String> imegUrls) {
        this.imegUrls = imegUrls;
    }

    @Override
    public String toString() {
        return "ResponseObject{" +
                "locationObject=" + locationObject +
                ", imegUrls=" + imegUrls +
                '}';
    }
}
