package ru.perm.v.dagger_rest.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    @GET
    @Path("/{message}")
    public Response getMessage(@PathParam("message") String message) {
        if (message == null || message.isEmpty()) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Message must be not null")
                    .build();
        }
        return Response.ok(message).build();
    }
}
