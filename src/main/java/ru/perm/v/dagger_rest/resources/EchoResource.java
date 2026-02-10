package ru.perm.v.dagger_rest.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/echo")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class EchoResource {

    @GET
    @Path("/{message}")
    public Response getMessage(@PathParam("message") String message) {
        if (message == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Message must be not null")
                    .build();
        }
        if (message.length() < 4) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Length of the Message must be greater than 4")
                    .build();
        }
        return Response.ok(message).build();
    }
}