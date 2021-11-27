package com.example.resource;

import com.example.pojo.Fish;
import com.example.service.FishService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/fish")
public class FishResource {

    @Inject
    FishService fishService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public Response getFishes() {
        return Response.ok(fishService.getFishes()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/init")
    public Response getFish() {
        return Response.ok(fishService.initFish()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateFish(Fish fish) {
        return Response.ok(fishService.updateFish(fish)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete")
    public Response deleteFish(Fish fish) {
        return Response.ok(fishService.deleteFish(fish)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insertFish(Fish fish) {
        return Response.ok(fishService.insertFish(fish)).build();
    }
}
