package br.unitins.tp1.resource;

import br.unitins.tp1.dto.TecladoDTO;
import br.unitins.tp1.service.TecladoService;
import jakarta.inject.Inject;
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
@Path("/teclado")
public class TecladoResource {
    
    @Inject
    public TecladoService tecladoService;

    @GET

    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(tecladoService.findById(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(tecladoService.findAll()).build();
    }

    @GET
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        return Response.ok(tecladoService.findByNome(nome)).build();
    }

    @POST
    public Response create(TecladoDTO dto) {
        return Response.status(Status.CREATED).entity(tecladoService.create(dto)).build();
    }

    @PUT
    @Path("/{id}")
    public Response update(@PathParam("id") Long id, TecladoDTO dto) {
        tecladoService.update(id, dto);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        tecladoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }
}
