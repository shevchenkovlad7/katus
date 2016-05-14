package com.insta.rest;

import com.insta.object.LocationObject;
import com.insta.object.ResponseObject;
import org.apache.http.client.ResponseHandler;
import org.apache.http.impl.client.BasicResponseHandler;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by gleb on 14.05.16.
 */
@Path("/locations")
public class Location {

    private ObjectMapper objectMapper = new ObjectMapper();
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

        String jsonLocations = result.toString();

        String[] mas = jsonLocations.split("\"id\": \"");

        for (String s : mas) {
            if (s.indexOf("name") != -1) {
                int a = s.indexOf("\"");
                list.add(s.substring(0, a));
            }
        }

        List<ResponseObject> responseObjects = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(jsonLocations);
        JSONArray locations = jsonObject.getJSONArray("data");
        for (Object o : locations) {
            try {
                ResponseObject responseObject = new ResponseObject();
                responseObject.setLocationObject(objectMapper.readValue(o.toString(), LocationObject.class));
                responseObjects.add(responseObject);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return Response.ok().entity(list.get(1).toString()).build();
    }

}
