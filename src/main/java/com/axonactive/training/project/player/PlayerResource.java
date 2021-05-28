package com.axonactive.training.project.player;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

@Path("players")
@Stateless
public class PlayerResource {

    @Context
    private UriInfo uriInfo;

    @Inject
    PlayerService playerService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Player player) {
        this.playerService.add(player);
        URI playerUri = uriInfo.getAbsolutePathBuilder().path(player.getId().toString()).build();
        return Response.created(playerUri).entity(playerUri.toString()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player>  findAll() {
        return playerService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        Player newPlayer = playerService.find(id);
        if (Objects.isNull(newPlayer)) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(newPlayer).build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") Long id) {
        Player newPlayer = playerService.find(id);
        if (Objects.isNull(newPlayer)) {
            return Response.status(Status.NOT_FOUND).build();
        }
        this.playerService.delete(id);
        return Response.ok().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Player player) {
        Player newPlayer = playerService.find(player.getId());
        if (Objects.isNull(newPlayer)) {
            return Response.status(Status.NOT_FOUND).build();
        } else {
            this.playerService.update(player);
            URI playerUri = uriInfo.getAbsolutePathBuilder().path(player.getId().toString()).build();
            return Response.created(playerUri).entity(playerUri.toString()).build();
        }
    }

}
