package br.unitins.tp1.resource;

import br.unitins.tp1.dto.FormatoDTO;
import br.unitins.tp1.service.FormatoService;
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
@Path("/formato")
public class FormatoResource {

    
    @Inject
    public FormatoService formatoService;

    @GET

    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(formatoService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(formatoService.findAll()).build();
    }

    @POST
    public Response create(@Valid FormatoDTO dto) {
        return Response.status(Status.CREATED).entity(formatoService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, FormatoDTO dto) {
        formatoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        formatoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }


}
