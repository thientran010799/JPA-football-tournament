package com.axonactive.training.project.team;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import javax.ejb.Stateless;
import javax.ws.rs.Produces;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

@Path("teams")
@Stateless
public class TeamResource {

    @Context
    private UriInfo uriInfo;

    @Inject
    TeamService teamService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Team team) {
         this.teamService.addTeam(team);
         URI teamUri = uriInfo.getAbsolutePathBuilder().path(team.getId().toString()).build();
         return Response.created(teamUri).entity(teamUri.toString()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Team> findAll() {
        return teamService.findAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        Team newTeam = teamService.findById(id);
        if (Objects.isNull(newTeam)) {
            return Response.status(Status.NOT_FOUND).build();
        }
        return Response.ok(newTeam).build();
    }
}
