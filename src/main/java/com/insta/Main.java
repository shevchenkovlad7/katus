package com.insta;

import com.insta.rest.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gleb on 14.05.16.
 */
public class Main {
    public static void main(String[] args) {
        Location location = new Location();
        List<String> list = new ArrayList<>();

        location.urlPhotos(list);


    }
}
