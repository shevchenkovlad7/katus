package com.insta.rest;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gleb on 14.05.16.
 */
@Path("/locations")
public class Location {

    private String url;
    private String status;
    private String token = "1784510627.0df9892.cf751cc19fed4bec9a0eb629f20e0220";
    private BufferedReader bufferedReader;
    private List<String> list;


    @Path("/{paramX}/{paramY}")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getLocation(@PathParam("paramX") String paramX, @PathParam("paramY") String paramY) throws IOException {

        url = "https://api.instagram.com/v1/locations/search?lat=" + paramX + "&lng=" + paramY + "&access_token=" + token;
        list = new ArrayList<>();

        if (paramX == null || paramY == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);
        HttpResponse response = client.execute(request);
        status += response.getStatusLine().getStatusCode();

        bufferedReader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));


        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }

        String[] mas = result.toString().split("\"id\": \"");

        for (String s : mas)
            if (s.indexOf("name") != -1) {
                int a = s.indexOf("\"");
                list.add(s.substring(0, a));
            }


        return Response.ok().entity(list.get(1).toString()).build();
    }


}
