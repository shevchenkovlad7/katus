package com.insta.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
}
