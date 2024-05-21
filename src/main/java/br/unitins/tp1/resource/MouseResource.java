package br.unitins.tp1.resource;

import br.unitins.tp1.dto.MouseDTO;
import br.unitins.tp1.service.MouseService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/mouse")
public class MouseResource {
    
    @Inject
    public MouseService mouseService;

    @GET

    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(mouseService.findById(id)).build();
    }

    @GET
    @RolesAllowed({"Funcionario", "Cliente"})
    public Response findAll() {
        return Response.ok(mouseService.findAll()).build();
    }

    @GET
    @RolesAllowed("Cliente")
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(mouseService.findByNome(nome)).build();
    }

    @POST
    public Response create(@Valid MouseDTO dto) {
        return Response.status(Status.CREATED).entity(mouseService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, MouseDTO dto) {
        mouseService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        mouseService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
