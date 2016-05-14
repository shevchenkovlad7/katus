package com.insta.rest;

import com.insta.object.LocationObject;
import com.insta.object.ResponseObject;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by gleb on 14.05.16.
 */
@Path("/locations")
public class Location {

    private ObjectMapper objectMapper = new ObjectMapper();

    private String json = "{\n" +
            "  \"meta\": {\n" +
            "    \"code\": 200\n" +
            "  },\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"latitude\": 50.43675,\n" +
            "      \"id\": \"1028397495\",\n" +
            "      \"longitude\": 30.50529,\n" +
            "      \"name\": \"Apple Hall\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.451092894751,\n" +
            "      \"id\": \"217807774\",\n" +
            "      \"longitude\": 30.52244727543,\n" +
            "      \"name\": \"Київ, Майдан Незалежності\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.45,\n" +
            "      \"id\": \"212898659\",\n" +
            "      \"longitude\": 30.5233,\n" +
            "      \"name\": \"Kyiv, Ukraine\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.45,\n" +
            "      \"id\": \"213130700\",\n" +
            "      \"longitude\": 30.524166666667,\n" +
            "      \"name\": \"Maidan Nezalezhnosti\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.453513068636,\n" +
            "      \"id\": \"216662086\",\n" +
            "      \"longitude\": 30.516250196494,\n" +
            "      \"name\": \"Софіївська Площа\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.4513397,\n" +
            "      \"id\": \"1020897542\",\n" +
            "      \"longitude\": 30.5227394,\n" +
            "      \"name\": \"Maidan Nezalezhnosti, Kiev, Ukraine\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.450901762715,\n" +
            "      \"id\": \"243843693\",\n" +
            "      \"longitude\": 30.522806473541,\n" +
            "      \"name\": \"ТЦ Глобус\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.4556928,\n" +
            "      \"id\": \"1034770917\",\n" +
            "      \"longitude\": 30.5246243,\n" +
            "      \"name\": \"Paska Fest\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.450491918031,\n" +
            "      \"id\": \"130915\",\n" +
            "      \"longitude\": 30.528608659665,\n" +
            "      \"name\": \"Жовтневий Палац\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.453281002316,\n" +
            "      \"id\": \"421188974\",\n" +
            "      \"longitude\": 30.512007589976,\n" +
            "      \"name\": \"Betravel\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.463333333333,\n" +
            "      \"id\": \"260742094\",\n" +
            "      \"longitude\": 30.545,\n" +
            "      \"name\": \"Trukhaniv Island\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.426634,\n" +
            "      \"id\": \"236295082\",\n" +
            "      \"longitude\": 30.5636,\n" +
            "      \"name\": \"Museum of The History of Ukraine in World War II\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.43489840262,\n" +
            "      \"id\": \"38980893\",\n" +
            "      \"longitude\": 30.553838908241,\n" +
            "      \"name\": \"Книжковий Арсенал\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.45,\n" +
            "      \"id\": \"503524917\",\n" +
            "      \"longitude\": 30.528055555556,\n" +
            "      \"name\": \"October Palace\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.45077,\n" +
            "      \"id\": \"1030026362\",\n" +
            "      \"longitude\": 30.5215,\n" +
            "      \"name\": \"Хачапури и вино\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.447311111111,\n" +
            "      \"id\": \"213070434\",\n" +
            "      \"longitude\": 30.521972222222,\n" +
            "      \"name\": \"Khreshchatyk\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.434166666667,\n" +
            "      \"id\": \"213341927\",\n" +
            "      \"longitude\": 30.559166666667,\n" +
            "      \"name\": \"Kiev Pechersk Lavra\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.455236281782,\n" +
            "      \"id\": \"215803552\",\n" +
            "      \"longitude\": 30.520623967825,\n" +
            "      \"name\": \"Михайлівська Площа\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.451541062695,\n" +
            "      \"id\": \"227917505\",\n" +
            "      \"longitude\": 30.533456716186,\n" +
            "      \"name\": \"D*Lux Entertainment Complex\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"latitude\": 50.451111288136,\n" +
            "      \"id\": \"137004091\",\n" +
            "      \"longitude\": 30.522541941727,\n" +
            "      \"name\": \"Сушия На Майдане\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    @Path("/{paramX}/{paramY}")
    @GET
    @Produces(MediaType.TEXT_HTML)
    public Response getLocation(@PathParam("paramX") String paramX, @PathParam("paramY") String paramY) {
        if (paramX == null || paramY == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        List<ResponseObject> responseObjects = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(json);
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

        return Response.ok().entity("Hello word!").build();
    }

}
