package com.insta.rest;


import jdk.nashorn.internal.parser.JSONParser;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jettison.json.JSONObject;
import org.w3c.dom.Document;

import javax.validation.constraints.AssertFalse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by gleb on 14.05.16.
 */
@Path("/locations")
public class Location {

    @Path("/{paramX}/{paramY}")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getLocation(@PathParam("paramX") String paramX, @PathParam("paramY") String paramY) {
        if (paramX == null || paramY == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok().entity("Hello word!").build();
    }
    public List<String> urlPhotos(List<String> list){
        DefaultHttpClient hc = new DefaultHttpClient();
        ResponseHandler response = new BasicResponseHandler();
        HttpGet http = new HttpGet("https://www.instagram.com/explore/locations/217054655/");
        String html = "";
        try {
            html =(String) hc.execute(http, response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(html);

        Document doc = Jsoup.parse(html);



        return list;
    }
}
