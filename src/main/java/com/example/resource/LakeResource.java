package com.example.resource;

import com.example.pojo.Lake;
import com.example.service.LakeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/lake")
public class LakeResource {
    @Inject
    LakeService lakeService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get")
    public Response getLakes() {
        return Response.ok(lakeService.getLakes()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/init")
    public Response getLake() {
        return Response.ok(lakeService.initLake()).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response updateLake(Lake lake) {
        return Response.ok(lakeService.updateLake(lake)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/delete")
    public Response deleteLake(Lake lake) {
        return Response.ok(lakeService.deleteLake(lake)).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/insert")
    public Response insertLake(Lake lake) {
        return Response.ok(lakeService.insertLake(lake)).build();
    }

}
