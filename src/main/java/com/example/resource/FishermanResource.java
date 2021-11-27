package com.example.resource;

import com.example.pojo.Fisherman;
import com.example.service.FishermanService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fisherman")
public class FishermanResource {

    @Inject
    FishermanService fishermanService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public Response getFishermen() {
        return Response.ok(fishermanService.getFishermen()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/init")
    public Response getFisherman() {
        return Response.ok(fishermanService.initFisherman()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateFisherman(Fisherman fisherman) {
        return Response.ok(fishermanService.updateFisherman(fisherman)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete")
    public Response deleteFisherman(Fisherman fisherman) {
        return Response.ok(fishermanService.deleteFisherman(fisherman)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insertFisherman(Fisherman fisherman) {
        return Response.ok(fishermanService.insertFisherman(fisherman)).build();
    }
}
